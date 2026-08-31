t = int(input())

for i in range(t):
    l, r, d = map(int, input().split())

    bottom = l / d
    if bottom > 1:
        print(d)
    else:
        top = r // d * d + d
        print(top)