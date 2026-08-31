n,m=map(int, input().split())
q=n
r=0
w=n
while w>=m:
    q+=w//m
    w=w//m+(w-(w//m)*m)
print (q)