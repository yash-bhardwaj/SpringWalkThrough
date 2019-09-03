/**
 * 
 */
package com.bmw.imiles.util;

import java.util.Date;

import com.bmw.imiles.entity.Imiles;
import com.bmw.imiles.enumeration.ImilesEnum;
import com.bmw.imiles.model.ImilesRequest;

/**
 * @author avadheshkumar
 *
 */
public class ImilesUtil {
	public static Imiles createImiles(Imiles oldImiles, ImilesRequest imilesRequest) {
		Imiles newImiles = new Imiles();

		newImiles.setGcid(oldImiles.getGcid());
		newImiles.setVin(oldImiles.getVin());
		newImiles.setLatest(Boolean.TRUE);
		newImiles.setImilesCount(imilesRequest.getImiles());
		newImiles.setCreatedAt(new Date());
		newImiles.setLastUpdationDate(new Date());
		newImiles.setStatus(ImilesEnum.ACCREDITED.getStatus());
		String creditedOrRedemed = imilesRequest.getCreditedOrRedemed();
		newImiles.setCredittedOrDebitted(creditedOrRedemed);
		switch (creditedOrRedemed) {
		case "creditted":
			newImiles.setTotalImiles(oldImiles.getTotalImiles() + imilesRequest.getImiles());
			break;
		case "debitted":
			newImiles.setTotalImiles(oldImiles.getTotalImiles() - imilesRequest.getImiles());
		}
		return newImiles;
	}
}
