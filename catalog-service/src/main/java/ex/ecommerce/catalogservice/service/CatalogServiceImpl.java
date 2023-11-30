package ex.ecommerce.catalogservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ex.ecommerce.catalogservice.entity.CatalogEntity;
import ex.ecommerce.catalogservice.entity.repository.CatalogRepository;
import ex.ecommerce.catalogservice.service.response.CatalogServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {

	private final CatalogRepository catalogRepository;

	@Override
	public List<CatalogServiceResponse> getAllCatalogs() {
		List<CatalogEntity> entities = catalogRepository.findAll();
		return entities.stream()
			.map(CatalogServiceResponse::of)
			.collect(Collectors.toList());
	}
}
