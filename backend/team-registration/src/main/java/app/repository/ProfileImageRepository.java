package app.repository;

import org.springframework.data.repository.CrudRepository;

import app.model.ProfileImage;

public interface ProfileImageRepository extends CrudRepository<ProfileImage, Long> {

}
