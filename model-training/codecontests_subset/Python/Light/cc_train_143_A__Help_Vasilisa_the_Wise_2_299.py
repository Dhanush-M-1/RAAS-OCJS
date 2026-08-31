I = lambda: map(int, input().split())

r1, r2 = I()
c1, c2 = I()
d1, d2 = I()

for a in range(1, 10):
    b, c, d = r1-a, c1-a, d1-a
    if (    0<b<=9 and 0<c<=9 and 0<d<=9
        and b+d==c2 and c+d==r2 and b+c==d2 and len({a,b,c,d})>3
    ):
        print(a, b)
        print(c, d)
        break
else:
    print(-1)