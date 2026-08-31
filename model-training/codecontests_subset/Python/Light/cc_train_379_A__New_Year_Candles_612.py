m, n=map(int, input().split())
l=m
while l>n:
    m+=l//n
    l=l//n+l%n
if l==n:
    m+=n//l
print(m)