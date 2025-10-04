package introduce_kotlin.lec11

// 최상단 유틸 함수 중 메서드 시그니처가 겹치는 케이스는 올 수 없다.
//fun isDirectoryPath(path: String): Boolean {
//    return path.endsWith("/")
//}

fun isDirectoryPath(path: String, path2: String): Boolean {
    return path.endsWith("/")
}