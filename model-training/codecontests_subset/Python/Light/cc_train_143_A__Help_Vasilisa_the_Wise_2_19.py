r1 , r2 =map(int, input().split())
c1 , c2 = map(int, input().split())
d1 , d2 = map(int, input().split())
a = (r1 + c1 - d2) // 2
c = (c1 + r2 - d1) // 2
b = (r1 + c2 - d1) // 2
d = (r2 + c2 - d2 ) // 2
ans = a in range(1,10) and b in range(1,10) and c in range(1,10) and d in range(1,10)
eq = a != b and a != c and a != d and b != c and b != d and c != d
if d1 == a+d and d2 == b+c and r1 == a+b and r2 == c+d and c1 == a+c and c2 == b+d and ans and eq:
    print(a , b)
    print(c , d)
else :
    print(-1)