for i in range(int(input())):
    left, right, d = map(int, input().split())
    print(d if left > d else (right // d + 1) * d)
