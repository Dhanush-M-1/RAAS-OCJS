r1,r2= map(int, input().split())
c1,c2= map(int, input().split())
d1,d2= map(int, input().split())
# arr =[int(x) for x in input().split()]
y=(r1-c1+d2)//2
x=r1-y
n=c2-y
m=r2-n
ar=[x,y,m,n]
ar = sorted(set(ar))
if len(ar)==4 and ar[0]>0 and ar[3]<10 and r1==x+y and c1 == x+m and d1 == x+n:
    print(str(x),str(y))
    print(str(m),str(n))
else:
    print(str(-1))