r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
x,y=(c1-r2+d1)//2,((2*c2)+c1-r2-d1)//2
p,q=(r2+c1-d1)//2,(r2-c1+d1)//2
if p<=0 or q<=0 or x<=0 or y<=0:
    print("-1")
elif x==y or p==q or x==p or x==q or y==q or y==p:
    print("-1")
elif x>9 or y>9 or p>9 or q>9:
    print("-1")
else:
    print(x,y)
    print(p,q)
