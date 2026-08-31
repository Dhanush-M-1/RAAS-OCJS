for i in range(int(input())):
    left, right, d = map(int, input().split())
    ans = (d if left > d else 0) or (right // d + 1) * d
    print(ans if ans > 0 else -1)
