package com.wm.ECartPGPTeamTen.service;

import static com.wm.ECartPGPTeamTen.util.ECartUtil.INTERNAL_ERROR;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wm.ECartPGPTeamTen.dao.ProductsDao;
import com.wm.ECartPGPTeamTen.dao.UserDao;
import com.wm.ECartPGPTeamTen.exception.ECartException;
import com.wm.ECartPGPTeamTen.model.ProductsModel;
import com.wm.ECartPGPTeamTen.model.UserModel;
import com.wm.ECartPGPTeamTen.vo.CategoryAndBrandVO;

/**
 * r0m09yu
 */

@Service
public class ProductService {

	private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	UserDao userDao;

	@Autowired
	ProductsDao productsDao;

	public List<ProductsModel> getRecentSearches(int userId) throws ECartException {
		try {
			List<UserModel> list = userDao.findUserSearchesById(userId);
			logger.info("User details :list {0}" + list);
			String[] arr = list.get(0).getRecentSearches();
			List<ProductsModel> recentSearchList = productsDao.findProducts(arr);

			return recentSearchList;
		} catch (Exception e) {
			logger.error("Error occured " + e);
			throw new ECartException(INTERNAL_ERROR + " :: " + userId);
		}
	}

	public CategoryAndBrandVO getFavBrandsCategories(int userId) throws ECartException {
		try {
			CategoryAndBrandVO vo = new CategoryAndBrandVO();
			List<UserModel> list = userDao.findUserSearchesById(userId);
			logger.info("User details :list {0}" + list);
			String[] arr = list.get(0).getRecentSearches();
			List<ProductsModel> prodList = productsDao.findFavCatAndBrands(arr);
			logger.debug("After fetching product detail");
			if (prodList != null && prodList.size() > 0) {
				List<String> brandsList = prodList.stream().map(prod -> prod.getBrand()).collect(Collectors.toList());
				List<String> catList = prodList.stream().map(prod -> prod.getProductCategory())
						.collect(Collectors.toList());
				vo.setBrands(brandsList);
				vo.setCategories(catList);
			}
			return vo;
			
		} catch (Exception e) {
			logger.error("Error occured " + e);
			throw new ECartException(INTERNAL_ERROR + " :: " + userId);
		}
	}
}
