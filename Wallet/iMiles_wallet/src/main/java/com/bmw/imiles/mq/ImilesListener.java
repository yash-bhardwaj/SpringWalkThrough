/**
 * 
 */
package com.bmw.imiles.mq;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.bmw.imiles.entity.Imiles;
import com.bmw.imiles.repository.ImilesWalletRepository;

/**
 * @author avadheshkumar
 *
 */
@Component
public class ImilesListener {
	@Autowired
	private ImilesWalletRepository imilesRepository;

	@JmsListener(destination = "${imiles.in.queue}", containerFactory="jmsListenerContainerFactory")
	public void receiveMessage(final Imiles imiles) throws JMSException {
		 imilesRepository.save(imiles);
	}
}
