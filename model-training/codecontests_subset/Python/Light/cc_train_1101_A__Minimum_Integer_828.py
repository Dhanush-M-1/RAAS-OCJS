for i in range(int(input())):
    a, b, d = map(int, input().split())
    if a/d > 1:
        print(d)
    else:
        print(d*((b//d)+1))