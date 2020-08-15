# 와이어바알리 코딩테스트 과제

## 사용기술
- Kotlin
- Springboot 2.3.2
- Junit 5
- Mockmvc
- Fuel (Http networkling lib)
- jsp

## 프로젝트 설명
- 서버에서 get method 호출 시 환율정보를 얻어오고 이후 연산처리는 전부 자바스크립트에서 처리합니다.
- kotlin를 지원하는 fuel lib를 사용하여 api 호출하였고 json 데이터를 파싱하여 모델 객체에 담아 넘겼습니다.
- 테스트코드는 환율정보 api를 호출하는 시점, 호출해서 데이터를 검증, controller method 호출부분 형태로 구현하였습니다.
- 템플릿 엔진은 사용가능한 템플릿 엔진 및 프론트 프레임워크가 없어 jsp로 구현하였습니다.
