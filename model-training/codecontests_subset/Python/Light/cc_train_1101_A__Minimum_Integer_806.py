for _ in range(int(input())):
    L, R, D = map(int, input().split())
    print(D + (0, R-R%D)[L<=D<=R])