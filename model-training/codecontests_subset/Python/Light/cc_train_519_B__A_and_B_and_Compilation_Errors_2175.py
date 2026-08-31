if __name__ == "__main__":
    N = int(input())
    init = list(map(int, input().split()))
    sec = list(map(int, input().split()))
    val1 = 0
    for x in init:
        val1 ^= x
    for x in sec:
        val1 ^= x
    third = list(map(int, input().split()))
    val2 = 0
    for x in third:
        val2 ^= x
    for x in sec:
        val2 ^= x
    print(val1)
    print(val2)
