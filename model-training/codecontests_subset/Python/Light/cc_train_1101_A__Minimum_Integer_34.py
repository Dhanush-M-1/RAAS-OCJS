for _ in range(int(input())):
    a,b,c = map(int, input().split())
    print(c if c < a else (b//c+1)*c)
