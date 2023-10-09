alter table tb_categories add deleted_at TIMESTAMP,add active boolean;
update tb_categories set active = true;