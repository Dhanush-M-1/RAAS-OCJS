def f():
    x, y = map(int,input().split());c=0;v=1
    while v<=x:
        c += 1
        if v % y == 0:
            x += 1
        v += 1
    print(c)
f()