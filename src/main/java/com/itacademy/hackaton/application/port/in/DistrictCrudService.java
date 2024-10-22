package com.itacademy.hackaton.application.port.in;

import com.itacademy.hackaton.adapter.controllers.IncomeResponseModel;
import com.itacademy.hackaton.adapter.data.entities.DistrictDataRecord;
import com.itacademy.hackaton.adapter.data.repository.DistrictDataRepository;
import com.itacademy.hackaton.application.exceptions.DistrictRetrievalException;
import com.itacademy.hackaton.application.exceptions.NoDistrictFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.Comparator;

import static java.lang.Math.toIntExact;
import static reactor.core.publisher.Flux.error;

@Service
@RequiredArgsConstructor
public final class DistrictCrudService {

    private final DistrictDataRepository districtDataRepository;

    public static final String AN_EMPTY_FLUX = "The repository returned an empty flux.";

    public Flux<IncomeResponseModel> getAllDistricts() {

        return districtDataRepository.findAll()

                .switchIfEmpty(error(new NoDistrictFoundException(AN_EMPTY_FLUX)))

                .map(DistrictCrudService::mapToIncomeResponseModel)

                .sort(Comparator.comparingDouble(IncomeResponseModel::getValor))

                .index()

                .map(DistrictCrudService::addColorValueToRecord)

                .onErrorMap(e -> new DistrictRetrievalException(e.getMessage()));

    }

    private static IncomeResponseModel addColorValueToRecord(Tuple2<Long, IncomeResponseModel> recordTuple) {

        IncomeResponseModel incomeResponseModel = recordTuple.getT2();

        incomeResponseModel.setColorIndex(toIntExact(recordTuple.getT1()));

        return incomeResponseModel;

    }

    private static IncomeResponseModel mapToIncomeResponseModel(DistrictDataRecord record) {

        return new IncomeResponseModel(
                record.getId(),
                record.getDistrictName(),
                record.getAvgIncome(),
                null
        );

    }

}
