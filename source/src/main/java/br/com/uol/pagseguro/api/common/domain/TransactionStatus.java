/*
 * 2007-2016 [PagSeguro Internet Ltda.]
 *
 * NOTICE OF LICENSE
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Copyright: 2007-2016 PagSeguro Internet Ltda.
 * Licence: http://www.apache.org/licenses/LICENSE-2.0
 */
package br.com.uol.pagseguro.api.common.domain;

/**
 * Class for transaction status
 *
 * @author PagSeguro Internet Ltda.
 */
public class TransactionStatus {

	private final Integer statusId;

	/**
	 * Constructor
	 *
	 * @param statusId
	 *            Status id
	 */
	public TransactionStatus(Integer statusId) {
		this.statusId = statusId;
	}

	/**
	 * Get status id
	 *
	 * @return Status id
	 */
	public int getStatusId() {
		return statusId;
	}

	/**
	 * Get status by status id
	 *
	 * @return Status
	 * @see Status
	 */
	public Status getStatus() {
		return Status.fromStatusId(statusId);
	}

	/**
	 * Status enum
	 */
	public enum Status {

		INITIATED("THE TRANSACTION HAS NOT BEEN COMPLETED", 0),
		WAITING_PAYMENT("THE PAYMENT HAS NOT YET BEEN PROCESSED", 1),
		IN_ANALYSIS("THE PAYMENT IS UNDER RISK REVIEW", 2),
		PAID("THE TRANSACTION PAYMENT HAS BEEN CONFIRMED", 3),
		AVAILABLE("THE TRANSACTION AMOUNT IS AVAILABLE FOR APPLICATION TO WITHDRAW", 4),
		IN_DISPUTE("THE TRANSACTION IS IN DISPUTE", 5),
		REFUNDED("THE TRANSACTION AMOUNT WAS RETURNED TO BUYER", 6),
		CANCELLED("THE TRANSACTION HAS BEEN CANCELLED", 7),
		SELLER_CHARGEBACK(
				"THE PAYMENT WAS CONTESTED BY THE BUYER AND THE TRANSACTION AMOUNT PREVIOUSLY BLOCKED WAS DEBITED FROM YOUR BALANCE",
				8),
		CONTESTATION(
				"THE PAYMENT WAS CONTESTED BY THE BUYER AND THE TRANSACTION AMOUNT WAS BLOCKED. YOU MUST CONTACT OUR CUSTOMER SERVICE",
				9),
		UNRECOGNIZED("UNKNOWN STATUS. SEE ONLINE DOCUMENTATION", -1);

		/**
		 * Enum description
		 */
		private String description;

		/**
		 * Enum value
		 */
		private Integer statusId;

		/**
		 * Initializes a newly created enum constant of this type with the specified
		 * arguments
		 * 
		 * @param description
		 *            the description of the enum constant
		 * @param value
		 *            the value of the enum constant
		 */
		Status(String description, Integer value) {
			this.description = description;
			this.statusId = value;
		}

		/**
		 * Get status by status id
		 *
		 * @param statusId
		 *            Status id
		 * @return Status
		 */
		public static Status fromStatusId(Integer statusId) {
			for (Status status : Status.values()) {
				if (status.statusId != null && status.statusId == statusId) {
					return status;
				}
			}
			return UNRECOGNIZED;
		}

		public Integer getStatusId() {
			return statusId;
		}

		public String getDescription() {
			return description;
		}

	}

}
