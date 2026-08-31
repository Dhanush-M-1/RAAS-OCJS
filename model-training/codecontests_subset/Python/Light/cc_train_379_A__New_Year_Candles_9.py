n,m=[int(i) for i in input().split()]
c=n 
d=0
while(True):
    x=n//m 
    c+=x 
    n=x+(n%m)
    if(n<m):
        break 
print(c)