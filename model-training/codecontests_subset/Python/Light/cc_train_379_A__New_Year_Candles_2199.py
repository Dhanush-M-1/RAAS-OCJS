n,m=map(int,input().split())
c=n
r=0
for i in range(1000):
    if n!=0:
        if n//m==0:
            r=r+n
        elif n>=m:
            r=r+(n%m)
            
        if r>=m:      
            c=c+1
            r=r-m+1
        n=n//m
        c=c+n        
    else:
        print(c)
        break

