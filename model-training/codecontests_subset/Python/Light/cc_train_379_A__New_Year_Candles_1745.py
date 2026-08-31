n,m = map(int, input().split())
t=ret=0
while n > 0:
    n-=1
    t+=1
    if (t==m):
        n+=1
        t=0
    ret+=1
print(ret)