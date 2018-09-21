package org.gongjian.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
public class TransactionService {

	@Transactional(propagation = Propagation.MANDATORY)
	public void scheduleAfterTransaction() {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {

			@Override
			public void afterCommit() {
				System.out.println("after commit");
			}

			@Override
			public void afterCompletion(int status) {
				System.out.println("after completion");
			}
		});
	}

}
