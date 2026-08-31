
list = [1,2,3,4,5,6,7,8,9]


r1,r2 = map(int,input().split())

c1,c2 = map(int,input().split())

d1,d2 = map(int,input().split())

a = (d1 - r2 + c1)//2

d = (r2 - c1 + d1)//2

b = r1 - a

c = r2 - d

if a in list and b in list and c in list and d in list and a!=b and a!=c and a!=d and b!=c and c!=d and b!=d:
 print(a,b)
 print(c,d)


else:
    print(-1)


