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

[유저결과물](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EA%B2%B0%EA%B3%BC%EB%AC%BC/%EC%9C%A0%EC%A0%80%EA%B2%B0%EA%B3%BC%EB%AC%BC.md)

![카테고리](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[카테고리 결과물](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EA%B2%B0%EA%B3%BC%EB%AC%BC/%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC%EA%B2%B0%EA%B3%BC%EB%AC%BC.md)

![상품](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%83%81%ED%92%88%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[상품 결과물](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EA%B2%B0%EA%B3%BC%EB%AC%BC/%EC%83%81%ED%92%88%EA%B2%B0%EA%B3%BC%EB%AC%BC.md)

![장바구니](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[장바구니 결과물](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EA%B2%B0%EA%B3%BC%EB%AC%BC/%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88%EC%84%B1%EA%B3%BC%EB%AC%BC.md)

![주문](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EC%A3%BC%EB%AC%B8%EC%BB%A8%ED%8A%B8%EB%A1%A4%EB%9F%AC.PNG?raw=true)

[주문 결과물](https://github.com/djawlths3/shopping-mall/blob/master/doc/img/%EA%B2%B0%EA%B3%BC%EB%AC%BC/%EC%A3%BC%EB%AC%B8%EC%84%B1%EA%B3%BC%EB%AC%BC.md)

## 고려한 점

1. ##### 회원 가입 시 validation 과 암호화 방안

   validation은 자바에 valid 어노테이션을 이용 필요한 조건을 만들어서 사용.

   정규식을 통해 제한.

    로그인 시에도 특수문자는 입력을 제한.

   비밀번호 암호화는 프로트 단에서 bcryp 라이브러리를 이용 단방향 암호화를 제공

   사용자 개인 정보에 대한 암호화는 AES512를 이용 db에서 진행.

2. #####  아이디 찾기, 비밀번호 찾기

   아이디는 email가 이름을 통해 검색, 비밀번호는 우선 아이디를 통해 가입한 이메일로 인증 번호를 보냄

   다시 아이디와 인증번호가 일치 하면 비밀번호 변경. 변경 시 인증번호도 변경 하여 db에 저장.

   (소스에서는 이메일로 인증번호를 전송하는 기능은 추가하지 못함.)

3. ##### 카테고리 관리

   카테고리는 상품과 1대n 관계 만약 새로운 카테고리가 생성 될 경우 상품을 이동 시키려고 했으나(ex: best 상품카테고리 생성 시 best라는 카테고리를 만든 뒤 상품 이동 ) 그럴경우 상품을 다양하게 검색하지 못하기 때문에 n:m 관계로 DB변경 예정

4. ##### 상품 옵션 중복 

   상품 옵션에 대해서는 size와 color를 이용하여 pk키를 걸어서 중복 회피.

   옵션은 상품 옵션 테이블을 따로 만들어서 옵션을 늘릴 수 있게 하였으며  다양한 옵션은 color 컬럼을 이용하여 구분.(예: 빨간 잠바, 빨간 잠바(용무니) 이런식으로 상품에 색깔 외에 다른 옵션이 들어간다면 color 칼럼에 빨간잠바용무늬 라는 값 추가. 사실상 color로 상품 옵션 구분)

5. ##### 장바구니

   회원은 장바구니를 회원번호로 구분 만약 회원 번호가 없다면(비회원)  고객 ip(혹은 세션. 일단은 ip로 구현)를 가지고 구분 회원 번호가 없는 장바구니 데이터는 12시마다 프로시저를 이용하여 삭제.

6. ##### 주문

   상품 주문은 단일상품 주문과 장바구니 주문으로 구분해서 처리. 

   비회원 주문일 경우는 비밀번호를 입력하게해서 비회원 주문조회를 할 수 있게 처리. 주문번호는  문자+날짜+그날주문횟수로 만들어 관리

7. ##### 재고

   재고는 주문 완료시 동시에 수정. 주문 도중이라도 재고가 없다면 실패 . 트랜잭션을 이용하여 원자성 보장






