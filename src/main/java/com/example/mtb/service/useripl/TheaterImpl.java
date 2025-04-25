package com.example.mtb.service.useripl;

import com.example.mtb.dto.TheaterRegistrationRequest;
import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exception.TheaterNotFoundException;
import com.example.mtb.exception.UserNotFoundException;
import com.example.mtb.repository.TheaterOwnerRepository;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserDetailsRepository;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.mtb.enums.UserRole.THEATER_OWNER;

@AllArgsConstructor
@Service
public class TheaterImpl implements TheaterService {

    private final TheaterRepository theaterrepository;
    private final UserDetailsRepository userDetailsRepository;
    private  final TheaterOwnerRepository theaterOwnerRepository;
    @Override
    public TheaterResponse registration(String email, TheaterRegistrationRequest request) {
        Optional<UserDetails> optionalUserDetails = Optional.ofNullable(userDetailsRepository.findByEmail(email));
        UserDetails user = optionalUserDetails.get();


        if (user == null) {
            throw new UserNotFoundException("User Not found");
        } else
            if (user.getUserRole() == THEATER_OWNER) {
            Theater theater = new Theater();
            theater.setName(request.name());
            theater.setAddress(request.address());
            theater.setCity(request.city());
            theater.setLandmark(request.landmark());

            List<Theater> theaterlist = new ArrayList<>();
            theaterlist.add(theater);
            TheaterOwner owner= new TheaterOwner();
            owner.setTheater(theaterlist);
            theater.setTheaterOwner((TheaterOwner) user);

                theaterrepository.save(theater);

                theaterOwnerRepository.save(owner);
            return new TheaterResponse(theater.getName(), theater.getAddress(), theater.getCity(), theater.getLandmark(),theater.getCreateAt(),theater.getUpdatedAt(),theater.getCreatedBy());

            }else
                throw new UserNotFoundException("user not a theater owner");
    }

    @Override
    public Theater findById(String theaterId) {
        Optional<Theater> optionalTheater = theaterrepository.findById(theaterId);
        if(optionalTheater.isPresent()){
            Theater theater = optionalTheater.get();
            return theater;
        }else
            throw new TheaterNotFoundException(" Theater not exist");

    }

    @Override
    public TheaterResponse updateTheater(String theaterId, TheaterRequest request) {
        Optional<Theater> optionalTheater = theaterrepository.findById(theaterId);

        if(optionalTheater.isPresent()){
            Theater existTheater = optionalTheater.get();

            existTheater.setName(request.name());
            existTheater.setAddress(request.address());
            existTheater.setCity(request.city());
            existTheater.setLandmark(request.landmark());

            theaterrepository.save(existTheater);
            return new TheaterResponse(existTheater.getName(),existTheater.getAddress(),existTheater.getCity(),existTheater.getLandmark(),existTheater.getCreateAt(),existTheater.getUpdatedAt(),existTheater.getCreatedBy());

        }else
            throw new TheaterNotFoundException(" Theater not exists");
    }
}