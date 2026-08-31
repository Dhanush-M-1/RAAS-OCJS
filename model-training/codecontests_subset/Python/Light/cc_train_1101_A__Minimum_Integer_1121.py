def f():
    x = int(input())
    for xxx in range(x):
        l , r, d = map(int, input().split())
        if d < l or d > r:
            print(d)
        else:
            rem = r // d
            print(d + (d*rem))
f()