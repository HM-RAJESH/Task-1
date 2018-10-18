
package com.lunatech.demo.services.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lunatech.demo.services.entity.TopRatedMovie;
import com.lunatech.demo.services.manager.LunatechManager;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/")
@Api("/api/v1/")
public class LunatechServiceController {
	
	@Autowired
	private LunatechManager lunatechManager;
	
	@GetMapping(value = "films/{genretype}", produces = "application/json")
	
	@ApiOperation(value = "Get Top Rated films using Type", notes = "Get Top Rated films using Type", response = TopRatedMovie.class, responseContainer="List")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "genretype", value = "genretype", paramType = "path", required = true) })
	public ResponseEntity<List<TopRatedMovie>> getTopRatedMovies(@PathVariable("genretype") String genretype) {
		
		List<TopRatedMovie> l = lunatechManager.getTopRatedFilms(genretype);
		return ResponseEntity.ok(l);
	}
}

