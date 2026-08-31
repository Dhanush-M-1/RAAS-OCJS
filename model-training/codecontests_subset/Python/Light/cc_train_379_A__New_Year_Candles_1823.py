n,m=map(int,input().split(" "))
su=n
while(n!=0):
    su+=n//m
    d=0
    if(n>=m):
        d=n%m
    n=n//m+d
print(su)