# GIT Convention
## GIT Flow
Git-flow를 사용한다.
* master: 기준이 되는 브랜치로 제품을 배포하는 브랜치
* develop: 개발 브랜치로 개발자들이 이 브랜치를 기준으로 각자 작업한 기능들을 Merge
* feature: 단위 기능을 개발하는 브랜치로 기능 개발이 완료되면 develop 브랜치에 Merge
* release: 배포를 위해 master 브랜치로 보내기 전에 먼저 QA(품질검사)를 하기위한 브랜치
* hotfix: master 브랜치로 배포를 했는데 버그가 생겼을 때 긴급 수정하는 브랜치

## GIT Convention
1. Commit Message
   * 기본적으로 커밋 메세지는 제목/본문/꼬리말로 구성한다
2. Commit Type
   * feat : 새로운 기능 추가
   * fix : 버그 수정
   * docs : 문서 수정
   * style : 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
   * refactor : 코드 리펙토링
   * test : 테스트 코드, 리펙토링
   * chore : 빌드 업무 수정, 패키지 매니저 수정
3. Subject
   * 제목은 50자를 넘기지 않고, 마침표를 붙이지 않는다
   * 과거시제를 사용하지 않고 명령어로 작성한다
4. Body
   * 선택사항이기 때문에 모든 커밋에 본문 내용을 작성할 필요가 없다
   * 부연설명이 필요하거나 커밋의 이유를 설명할 경우 작성한다
   * 72자를 넘기지 않고 제목과 구분되기 위해 한 칸을 띄어 작성한다
5. footer
   * 선택사항이기 때문에 모든 커밋에 꼬릿말을 작성할 필요는 없음
   * issue tracker id를 작성할 때 사용