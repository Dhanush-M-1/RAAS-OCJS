n,m=[int(x) for x in input().split()]
d=n
k=n
l=n
while(k>=1):
    k=n/m 
    n/=m
    l+=k
print(int(l))