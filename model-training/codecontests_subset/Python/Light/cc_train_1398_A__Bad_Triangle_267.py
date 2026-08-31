for _ in range(int(input())):
    i_liczb = int(input())
    liczby = list(map(int, input().split()))
    a, b, c = liczby[0], liczby[1], liczby[-1]
    if a + b <= c:
        print(1, 2, i_liczb)
    else:
        print(-1)