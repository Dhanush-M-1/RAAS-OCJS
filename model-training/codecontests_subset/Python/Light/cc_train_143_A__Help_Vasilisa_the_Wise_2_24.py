r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
check = True
x = 0
a = 0
b = 0
c = 0

for i in range(1, 10, 1):
    x = i
    a = r1 - x
    b = d2 - a
    c = r2 - b
    if 1 <= a <= 9 and 1 <= b <= 9 and 1 <= c <= 9 :
        if a != b and a != c and b != c and x != a and x != b and x != c:
            if (x + c) == d1 and (x + b) == c1 and (a + c) == c2:
                check = False
                break 

if check:
    print(-1)
else:
    print(x, a)
    print(b, c)
