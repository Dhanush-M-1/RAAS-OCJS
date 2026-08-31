n,m = map(int,input().split())
c=n
while n>=m :
    k=int(n%m)
    n=(n//m)
    c=c+n
    n=k+n
print(int(c))
