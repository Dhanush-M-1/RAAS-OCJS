n,m=[int(x) for x in input().split()]
a=n
while int(n/m)>=1:
        a+=int(n/m)
        n=int(n/m)+n%m
print(a)