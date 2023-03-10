INSERT INTO warehouse (title, city, street, latitude, longitude) VALUES
('Івано-Франківський склад', 'Івано-Франківськ', 'вул. Євгена Коновальця, 229', 48.90727690575747, 24.716455981655702),
('Львівський склад', 'Львів', 'вул. Пирогівка, 42', 49.80339113541739, 24.081925899736376),
('Київський склад', 'Київ', 'Велика Окружна дорога, 98а', 50.40909444512023, 30.398960144522583),
('Київський склад 2', 'Київ', 'Велика Окружна дорога, 98', 50.4024649811355, 30.398123579731671),
('Вінницький склад', 'Вінниця', 'вул. Київська, 16', 49.23914764534477, 28.480540659922774);

INSERT INTO transporter (fullname, car_model, load_capacity) VALUES
('Мироненко В.Р.', 'DAF XF105', 15590),
('Огоновський Ч.Р.', 'Volvo FH16', 34000),
('Костогриз Д.О.', 'Volkswagen LK40', 1125),
('Палагнюк З.С.', 'DAF XF105', 15590),
('Конончук Й.О.', 'Renault Traffic', 1266),
('Гудзь А.Б.', 'Mercedes Sprinter', 3494),
('Вінтонів О.К.', 'Man TGX', 22050),
('Овечко П.У.', 'Iveco S-Way', 11705);

INSERT INTO delivery (cargo_name, cargo_weight, delivery_status, warehouse_from_id, warehouse_to_id, transporter_id) VALUES
('огірки', 18000, 'PROCESSING', 1, 3, 7),
('морква', 1100, 'ACCEPTED', 1, 4, 3),
('херсонські кавуни', 32000, 'IN_TRANSIT', 2, 2, 2),
('грейпфрути', 800, 'IN_TRANSIT', 2, 4, 5),
('апельсини', 3100, 'ACCEPTED', 1, 3, 6),
('ківі', 1000, 'PICKED_UP', 3, 2, 3),
('помідори', 11000, 'CANCELED', 4, 3, 4),
('банани', 17000, 'DELIVERED', 2, 1, 7),
('мандарини', 10000, 'IN_TRANSIT', 3, 2, 8),
('цибуля', 14000, 'ACCEPTED', 2, 3, 4),
('дині', 12000, 'DELIVERED', 4, 1, 1),
('яблука', 13500, 'PICKED_UP', 3, 2, 1);