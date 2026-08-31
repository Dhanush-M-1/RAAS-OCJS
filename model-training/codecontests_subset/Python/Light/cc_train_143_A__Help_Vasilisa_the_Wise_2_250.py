r1, r2 = [int(y) for y in input().split()]
c1, c2 = [int(y) for y in input().split()]
d1, d2 = [int(y) for y in input().split()]
a = (r1+c1-d2)//2
b = r1 - a
c = c1 - a
d = d1 - a
if a not in range(1,10) or b not in range(1,10) or c not in range(1,10) or d not in range(1,10):
    print(-1)
elif a == b or a == c or a == d or b == c or b == d or c == d:
    print(-1)
elif a+b != r1 or c+d != r2 or a+c != c1 or b+d != c2 or a+d != d1 or b+c != d2:
    print(-1)
else:
    print(a,b)
    print(c,d)