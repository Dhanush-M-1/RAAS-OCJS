
t = int(input())


for _ in range(t):
    l, r, d = map(int, input().split())

    s = d * (l // d)
    e = d * (r // d) + d
    f = 0
    for i in range(d,s+1,d):
        if i < l and i % d == 0:
            print(i)
            f = 1
            break
    if f == 0:
        print(e)
