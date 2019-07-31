# 쇼핑몰 프로젝트

## 작업계획

| 번호 | API 기능                        | URL                        | 예상 | 소요시간 | 완료/미완료 | 비고                                                         |
| :--: | :------------------------------ | :------------------------- | :--: | :------: | :---------: | ------------------------------------------------------------ |
|  1   | 회원가입                        | /api/user/join             | 7/22 |    1h    |      O      | 첫 세팅, validate 설정                                       |
|  2   | 아이디 중복검사                 | /api/user/checkId          | 7/22 |   10m    |      O      |                                                              |
|  3   | 로그인                          | /api/user/login            | 7/22 |    1h    |      O      | 비밀번호, 아이디 잘못입력, 아이디 특수문자 금지              |
|  4   | 아이디 찾기                     | /api/user/findId           | 7/22 |   10m    |      O      |                                                              |
|  5   | 비밀번호 찾기                   | /api/user/findPw           | 7/22 |   10m    |      O      |                                                              |
|  6   | 비밀번호 변경                   | /api/user/modifyPw         | 7/23 |   10m    |      O      |                                                              |
|  7   | 회원정보 변경                   | /api/user/modify           | 7/23 |   10m    |      O      |                                                              |
|  8   | 비밀번호 인증키 인증            | /api/user/certification    | 7/23 |   10m    |      X      | 이메일 이용 인증키 인증                                      |
|  9   | 회원삭제(테스트용)              | /api/user/removeAll        | 7/23 |   10m    |      O      |                                                              |
|  10  | 카테고리 등록                   | /api/category/raise        | 7/23 |   10m    |      O      |                                                              |
|  11  | 카테고리 이름수정               | /api/category/modify       | 7/23 |   10m    |      O      |                                                              |
|  12  | 카테고리 삭제                   | /api/category/remove       | 7/23 |   10m    |      O      |                                                              |
|  13  | 카테고리 전체 삭제              | /api/category/removeAll    | 7/23 |   10m    |      O      |                                                              |
|  14  | 관리자 상품 등록                | /api/product/add           | 7/24 |   10m    |      O      |                                                              |
|  15  | 상품리스트(전체,검색)           | /api/product/list          | 7/24 |    1h    |      O      | 상품 전체 리스트, 정렬(가격,이름순), 이름검색, 카테고리별 검색 |
|  16  | 상품상세정보                    | /api/product/detail        | 7/24 |   10m    |      O      |                                                              |
|  17  | 관리자 상품수정                 | /api/product/modify        | 7/24 |   10m    |      O      |                                                              |
|  18  | 관리자 상품 중복검사            | /api/product/overlap       | 7/24 |   10m    |      O      |                                                              |
|  19  | 관리자 상품삭제                 | /api/product/remove        | 7/24 |   10m    |      O      |                                                              |
|  20  | 관리자 상품 옵션 등록           | /api/product/stock/add     | 7/25 |    2h    |      O      | 재고테이블, 상품테이블 DB 수정                               |
|  21  | 관리자 상품 옵션 수정           | /api/product/stock/modify  | 7/25 |   40m    |      O      | 상품img 포함                                                 |
|  22  | 관리자 상품 옵션 중복검사       | /api/product/stock/overlap | 7/25 |   10m    |      O      |                                                              |
|  23  | 관리자 상품 옵션 삭제           | /api/product/stock/remove  | 7/25 |   10m    |      O      |                                                              |
|  24  | 단일 상품 주문 생성             | /api/order/add             | 7/29 |    2h    |      O      | 회원, 비회원 구분                                            |
|  25  | 장바구니 상품 주문 생성         | /api/order/addBascket      | 7/29 |   30m    |      O      | 회원, 비회원 구분                                            |
|  26  | 관리자 주문 내용 수정(상태변경) | /api/order/modify          | 7/29 |    1h    |      O      | 주문, 결제 DB 수정                                           |
|  27  | 관리자 주문 삭제(완료)          | /api/order/remove          | 7/29 |   10m    |      O      |                                                              |
|  28  | 주문조회                        | /api/order/search          | 7/29 |   30m    |      O      | 회원, 비회원 구분                                            |
|  29  | 관리자 주문조회(전체,검색)      | /api/order/searchAll       | 7/29 |   10m    |      O      |                                                              |
|  30  | 장바구니 상품추가               | /api/bascket/add           | 7/26 |   30m    |      O      | 상품을 list로 받아서 처리, 회원 비회원 구분                  |
|  31  | 장바구니 상품 목록              | /api/bascket/list          | 7/26 |   30m    |      O      | 회원 비회원 구분                                             |
|  32  | 장바구니 상품 수량 수정         | /api/bascket/modify        | 7/26 |   30m    |      O      | 회원 비회원 구분                                             |
|  33  | 장바구니 상품 삭제              | /api/bascket/remove        | 7/26 |   30m    |      O      | 회원 비회원 구분                                             |
|  34  | 장바구니 삭제                   | /api/bascket/removeAll     | 7/26 |   30m    |      O      | 회원 비회원 구분                                             |
|      |                                 |                            |      |          |             |                                                              |
|      |                                 |                            |      |          |             |                                                              |

## TDD                                            

1. 유저테스트

   ![](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%9C%A0%EC%A0%80%ED%85%8C%EC%8A%A4%ED%8A%B8.PNG?raw=true)

2. 카테고리 테스트

   ![](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC%ED%85%8C%EC%8A%A4%ED%8A%B8.PNG?raw=true)

3. 상품 테스트

   ![](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%83%81%ED%92%88%ED%85%8C%EC%8A%A4%ED%8A%B8.PNG?raw=true)

4. 장바구니 테스트

   ![](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88%ED%85%8C%EC%8A%A4%ED%8A%B8.PNG?raw=true)

5. 주문 테스트

   ![](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%A3%BC%EB%AC%B8%ED%85%8C%EC%8A%A4%ED%8A%B8.PNG?raw=true)

[TDD 소스](https://github.com/djawlths3/shopping-mall/tree/master/src/test/java/com/cafe24/shopping/controller/api)



## swagger

![유저](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%9C%A0%EC%A0%80%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[유저 결과물]()

![카테고리](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[카테고리 결과물]()

![상품](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%83%81%ED%92%88%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[상품 결과물]()

![장바구니](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[장바구니 결과물]()

![주문](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%A3%BC%EB%AC%B8%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[주문 결과물]()



