package org.bsu.famcs.bookstoremobappserver.service;

import org.bsu.famcs.bookstoremobappserver.controller.entity.FavoriteInsertRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.FavoriteRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.UserInfoRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.to.BookTO;
import org.bsu.famcs.bookstoremobappserver.repository.BookRepository;
import org.bsu.famcs.bookstoremobappserver.repository.FavoriteRepository;
import org.bsu.famcs.bookstoremobappserver.repository.UserRepository;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Book;
import org.bsu.famcs.bookstoremobappserver.repository.entity.Favorite;
import org.bsu.famcs.bookstoremobappserver.repository.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProfileService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ProfileService(UserRepository userRepository, FavoriteRepository favoriteRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.favoriteRepository = favoriteRepository;
        this.bookRepository = bookRepository;
    }

    public UserInfoRs getUserInfo(String email) {
        return new UserInfoRs(userRepository.findUserByEmail(email));
    }


    public void addToFavorites(@RequestBody FavoriteInsertRq favoriteInsertRq) {
        UserEntity userEntity = userRepository.findUserByEmail(favoriteInsertRq.getUserId());
        if (userEntity == null) {
            //user not found
            return;
        }
        Book book = bookRepository.findById(favoriteInsertRq.getBookId()).orElse(null);
        if (book == null) {
            //book not found
            return;
        }
        if (!favoriteRepository.findByUserEntityAndBook(userEntity, book).isPresent())
            favoriteRepository.save(new Favorite(userEntity, book));
    }

    public FavoriteRs getFavorites(String userId) {
        return new FavoriteRs(StreamSupport
                .stream(favoriteRepository.findByUserEntity_Email(userId).spliterator(), false)
                .map(item -> new BookTO(item.getBook()))
                .collect(Collectors.toList()));
    }
}
