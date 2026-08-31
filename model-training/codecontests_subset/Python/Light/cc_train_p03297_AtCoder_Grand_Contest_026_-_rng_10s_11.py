def gcd(x,y):
    if x<y:
        x,y=y,x
    if y==0:
        return x
    else:
        return gcd(y,x%y)

T=int(input())
for _ in range(T):
    A,B,C,D=map(int,input().split())
    if D<B:
        print("No")
        continue
    if A<B:
        print("No")
        continue
    if C>=B:
        print("Yes")
        continue
    a=A%B
    d=D%B
    g=gcd(d,B)
    k=(C-a)//g
    if a+(k+1)*g>=B:
        print("Yes")
    else:
        print("No")