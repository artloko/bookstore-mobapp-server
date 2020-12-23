package org.bsu.famcs.bookstoremobappserver.controller.v1;

import org.bsu.famcs.bookstoremobappserver.controller.entity.FavoriteInsertRq;
import org.bsu.famcs.bookstoremobappserver.controller.entity.FavoriteRs;
import org.bsu.famcs.bookstoremobappserver.controller.entity.UserInfoRs;
import org.bsu.famcs.bookstoremobappserver.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {


    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/user/info")
    @ResponseBody
    public UserInfoRs signUp(@RequestParam String email) {
        return profileService.getUserInfo(email);
    }

    @PostMapping("/favorite")
    public void addToFavorites(@RequestBody FavoriteInsertRq favoriteInsertRq) {
        profileService.addToFavorites(favoriteInsertRq);
    }

    @GetMapping("/favorite")
    @ResponseBody
    public FavoriteRs getFavorites(@RequestParam String userId) {
        return profileService.getFavorites(userId);
    }
}
