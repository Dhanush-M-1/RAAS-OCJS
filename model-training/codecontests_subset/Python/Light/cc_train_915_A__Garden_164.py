n,m=map(int,input().split())
a=list(map(int,input().split()))
a.sort()
for i in a:
    if m % i==0:s=m/i
print(int(s))
