package booking.service;

import java.util.List;

import booking.dto.BookingDto;
import booking.dto.BookingListDto;
import booking.dto.ClientDto;
import booking.dto.EmployeeDto;

public interface BookingService {
	List<ClientDto> test() throws Exception;
	
	// CLIENT
	List<ClientDto> selectClientList() throws Exception;
	void insertClient(ClientDto client) throws Exception;
	void updateClient(ClientDto client) throws Exception;
	ClientDto clientDetail(int clientNo) throws Exception;
	void deleteClient(int clientNo) throws Exception;
	
	// THERAPIST
	List<EmployeeDto> openTherapistList() throws Exception;
	void insertTherapist(EmployeeDto therapist) throws Exception;
	void updateTherapist(EmployeeDto therapist) throws Exception;
	EmployeeDto therapistDetail(int empNo) throws Exception;
	void deleteTherapist(int empNo) throws Exception;
	
	// BOOKING
	List<BookingListDto> openUserBookingList(String clientId) throws Exception;
	List<BookingDto> openAdminBookingList() throws Exception;
	void insertBooking(BookingDto booking) throws Exception;
	void updateBooking(BookingDto booking) throws Exception;
	BookingDto bookingDetail(String bookingNo) throws Exception;
	EmployeeDto bookingTherapist(String empNo) throws Exception;
	void cancelBooking(String bookingNo) throws Exception;
	List<BookingDto> selectTherapist(int empNo) throws Exception;
	List<EmployeeDto> selectTherapistList() throws Exception;
	List<BookingDto> selectBookingTime(int empNo, String selStartTime, String selEndTime) throws Exception;
}
