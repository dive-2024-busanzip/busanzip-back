package com.example.busanzipback.domain.residency.util;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.busanzipback.common.exception.BusinessException;
import com.example.busanzipback.common.exception.CommonErrorCode;
import com.example.busanzipback.domain.residency.entity.BaseEntity;
import com.example.busanzipback.domain.residency.repository.AcademyRepository;
import com.example.busanzipback.domain.residency.repository.BeachRepository;
import com.example.busanzipback.domain.residency.repository.ElementarySchoolRepository;
import com.example.busanzipback.domain.residency.repository.FoodRepository;
import com.example.busanzipback.domain.residency.repository.HighSchoolRepository;
import com.example.busanzipback.domain.residency.repository.KindergartenRepository;
import com.example.busanzipback.domain.residency.repository.MiddleSchoolRepository;
import com.example.busanzipback.domain.residency.repository.ParkRepository;
import com.example.busanzipback.domain.residency.repository.ParkingLotRepository;
import com.example.busanzipback.domain.residency.repository.PoliceOfficeRepository;
import com.example.busanzipback.domain.residency.repository.SecurityFacilityRepository;
import com.example.busanzipback.domain.residency.repository.SubwayStationRepository;
import com.example.busanzipback.domain.residency.repository.TraditionalMarketRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RepositoryMapper {
	private Map<String, RepositoryWrapper<?,?>> mapper;
	private final AcademyRepository academyRepository;
	private final BeachRepository beachRepository;
	private final ElementarySchoolRepository elementarySchoolRepository;
	private final FoodRepository foodRepository;
	private final HighSchoolRepository highSchoolRepository;
	private final KindergartenRepository kindergartenRepository;
	private final MiddleSchoolRepository middleSchoolRepository;
	private final ParkingLotRepository parkingLotRepository;
	private final ParkRepository parkRepository;
	private final PoliceOfficeRepository policeOfficeRepository;
	private final SecurityFacilityRepository securityFacilityRepository;
	private final SubwayStationRepository subwayStationRepository;
	private final TraditionalMarketRepository traditionalMarketRepository;

	public Object[] getDetailInfoById(String category, Object id) {
		initMapper();
		Object[] info = new Object[3];
		BaseEntity baseEntity = mapper.get(category).findById(id).orElseThrow(
			() -> new BusinessException(CommonErrorCode.INVALID_SERVER_ERROR));
		info[0] = baseEntity.getName();
		info[1] = baseEntity.getLatitude();
		info[2] = baseEntity.getLongitude();
		return info;
	}

	private void initMapper() {
		mapper.put("art_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
		mapper.put("beach", new RepositoryWrapper<>(beachRepository, this::convertToInteger));
		mapper.put("cf_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("ch_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("crime_prevention_facility", new RepositoryWrapper<>(securityFacilityRepository, this::convertToInteger));
		mapper.put("cvn_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("dance_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
		mapper.put("elementary_school", new RepositoryWrapper<>(elementarySchoolRepository, this::convertToInteger));
		mapper.put("foreign_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
		mapper.put("fsh_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("high_school", new RepositoryWrapper<>(highSchoolRepository, this::convertToInteger));
		mapper.put("jp_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("kindergarten", new RepositoryWrapper<>(kindergartenRepository, this::convertToInteger));
		mapper.put("kr_fs", new RepositoryWrapper<>(foodRepository, this::convertToInteger));
		mapper.put("middle_school", new RepositoryWrapper<>(middleSchoolRepository, this::convertToInteger));
		mapper.put("music_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
		mapper.put("park", new RepositoryWrapper<>(parkRepository, this::convertToInteger));
		mapper.put("parking_lot", new RepositoryWrapper<>(parkingLotRepository, this::convertToInteger));
		mapper.put("police", new RepositoryWrapper<>(policeOfficeRepository, this::convertToInteger));
		mapper.put("studyroom_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
		mapper.put("subway_station", new RepositoryWrapper<>(subwayStationRepository, this::convertToInteger));
		mapper.put("traditional_market", new RepositoryWrapper<>(traditionalMarketRepository, this::convertToString));
		mapper.put("tutor_acdm", new RepositoryWrapper<>(academyRepository, this::convertToInteger));
	}
	private Integer convertToInteger(Object id) {
		if (id instanceof Integer) {
			return (Integer) id;
		} else if (id instanceof String) {
			return Integer.parseInt((String) id);
		} else {
			throw new IllegalArgumentException("Cannot convert to Integer: " + id);
		}
	}

	private String convertToString(Object id) {
		return String.valueOf(id);
	}

	private static class RepositoryWrapper<T, ID> {
		private final JpaRepository<T, ID> repository;
		private final Function<Object, ID> idConverter;

		RepositoryWrapper(JpaRepository<T, ID> repository, Function<Object, ID> idConverter) {
			this.repository = repository;
			this.idConverter = idConverter;
		}

		@SuppressWarnings("unchecked")
		public Optional<BaseEntity> findById(Object id) {
			return (Optional<BaseEntity>) repository.findById(idConverter.apply(id));
		}
	}
}
