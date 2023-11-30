package ex.ecommerce.catalogservice.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex.ecommerce.catalogservice.controller.response.CatalogWebResponse;
import ex.ecommerce.catalogservice.service.CatalogService;
import ex.ecommerce.catalogservice.service.response.CatalogServiceResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/catalogs")
@RequiredArgsConstructor
public class CatalogController {

	private final CatalogService catalogService;

	@GetMapping
	public ResponseEntity<List<CatalogWebResponse>> getAllCatalogs() {
		List<CatalogServiceResponse> response = catalogService.getAllCatalogs();
		return ResponseEntity.ok(
			response.stream()
				.map(CatalogWebResponse::of)
				.collect(Collectors.toList())
		);
	}
}
