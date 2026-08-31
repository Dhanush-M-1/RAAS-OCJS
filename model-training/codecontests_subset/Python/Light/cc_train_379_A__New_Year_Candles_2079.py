a,b = map(int,input().split())
s, f = 0,0
while True:
    if a > 0:
        s += 1
        f += 1
        a -= 1
        if f == b:
            a += 1
            f = 0
    else:
        print(s)
        break