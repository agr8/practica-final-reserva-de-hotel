INSERT INTO public.hotels(name, category) VALUES
	('Hotel Playa Resort', 1),
	('Hotel Playa Club', 1),
	('Hotel Centro Granada', 2),
	('Hotel Rural Montaña', 3),
	('Hotel Rural Pueblo', 3);

INSERT INTO public.availabilities("date", id_hotel, rooms) VALUES
	('13-10-22', 1, 5),
	('14-10-22', 1, 5),
	('15-10-22', 1, 5),
	('13-10-22', 2, 10),
	('14-10-22', 2, 8),
	('15-10-22', 2, 8),
	('13-10-22', 3, 0),
	('14-10-22', 3, 0),
	('15-10-22', 3, 0),
	('13-10-22', 4, 3),
	('14-10-22', 4, 3),
	('15-10-22', 4, 0),
	('16-10-22', 4, 1),
	('13-10-22', 5, 1),
	('14-10-22', 5, 1),
	('15-10-22', 5, 0),
	('16-10-22', 5, 0);
	

INSERT INTO public.bookings(id_hotel, date_from, date_to, email) VALUES
	(1, '13-10-22','15-10-22', 'pepe_48@gmail.com'),
	(2,'14-10-22', '15-10-22', 'rosajp@gmail.com'),
	(3, '13-10-22', '15-10-22', 'maria6739@gmail.com'),
	(5,'15-10-22' ,'16-10-22', 'cristinaui_98@gmail.com');
