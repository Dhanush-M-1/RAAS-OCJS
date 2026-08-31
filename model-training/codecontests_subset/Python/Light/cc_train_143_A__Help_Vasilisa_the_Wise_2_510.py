r1, r2 = map(int,input().split())
c1, c2 = map(int,input().split())
d1, d2 = map(int,input().split())

l1 = [1,2,3,4,5,6,7,8,9]

res = 0

for i in range(1, 10):
    x = i
    a = r1 - x
    b = c1 - x
    c = r2 - b

    if (x != a and x != b and x != c and a != b and a != c and b != c) and (a in l1 and b in l1 and c in l1 and x in l1) and (d1 == x + c and d2 == a + b and r1 == x + a and r2 == b + c and c1 == x + b and c2 == a + c):
        print(x, a)
        print(b, c)
        break

    res += 1

if res == 9: print(-1)
# Tue Oct 13 2020 23:24:35 GMT+0300 (Москва, стандартное время)
