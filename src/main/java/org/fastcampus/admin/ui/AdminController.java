package org.fastcampus.admin.ui;

import lombok.RequiredArgsConstructor;
import org.fastcampus.admin.ui.dto.*;
import org.fastcampus.admin.ui.dto.posts.*;
import org.fastcampus.admin.ui.dto.users.GetUserTableRequestDto;
import org.fastcampus.admin.ui.dto.users.GetUserTableResponseDto;
import org.fastcampus.admin.ui.query.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserStatsQueryRepository userStatsQueryRepository;
    private final AdminTableQueryRepository adminTableQueryRepository;

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("result", userStatsQueryRepository.getDailyRegisterUserStats(7));
        return mav;
    }

    @GetMapping("/users")
    public ModelAndView users(GetUserTableRequestDto dto) {
        ModelAndView mav = new ModelAndView("users");
        GetTableListResponse<GetUserTableResponseDto> result = adminTableQueryRepository.getUserTableData(dto);
        mav.addObject("requestDto", dto);
        mav.addObject("result", result.getTableData());
        mav.addObject("totalCount", result.getTotalCount());
        return mav;
    }

    @GetMapping("/posts")
    public ModelAndView posts(GetPostTableRequestDto dto) {
        ModelAndView mav = new ModelAndView("posts");
        GetTableListResponse<GetPostTableResponseDto> result = adminTableQueryRepository.getPostTableData(dto);
        mav.addObject("requestDto", dto);
        mav.addObject("result", result.getTableData());
        mav.addObject("totalCount", result.getTotalCount());
        return mav;
    }
}
