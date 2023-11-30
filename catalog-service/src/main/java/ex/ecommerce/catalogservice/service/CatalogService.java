package ex.ecommerce.catalogservice.service;

import java.util.List;

import ex.ecommerce.catalogservice.service.response.CatalogServiceResponse;

public interface CatalogService {
	List<CatalogServiceResponse> getAllCatalogs();
}
