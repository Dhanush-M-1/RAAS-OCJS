q = int(input())
for i in range(q):
    a = 0
    l,r,d=map(int, input().split())
    while True:
        a += d
        if d < l:
            a = d
            break
        if l <= a <= r:
            a = (r // d + 1) * d
        if a % d == 0:
            break
    print(a)
