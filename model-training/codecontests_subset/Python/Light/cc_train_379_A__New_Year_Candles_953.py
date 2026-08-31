a,b=[int(x) for x in input().split()]
m,n,c=[a,0,0]
while m>0:
    n+=m
    m,c=[(m+c)//b,(m+c)%b]
print(n)