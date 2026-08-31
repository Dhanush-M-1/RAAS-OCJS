r1, r2 = (int(i) for i in input().split())
c1, c2 = (int(i) for i in input().split())
d1, d2= (int(i) for i in input().split())

eq1 = r1 + c1 + d1 # 3a 
eq2 = r1 + c2+ d2 # 3b
eq3 = r2 + c1 + d2 # 3c
eq4 = r2 + c2 + d1 # 3d

s = eq1 + eq2 + eq3 + eq4

s /= 6

a = (eq1-s)/2
b = (eq2-s)/2
c = (eq3-s)/2
d = (eq4-s)/2

if a==b or a==c or a==d or c==b or d==b or c==d or a>9 or b>9 or c>9 or d>9 or a<1 or b<1 or c<1 or d<1: #a != int(a) or b != int(b) or c != int(c) or d != int(c):
    print(-1)
else:
    print(int(a), int(b))
    print(int(c), int(d))
