a,b=map(int,input().split())
th=0
nc=0
while(a):
    a-=1
    nc+=1
    th+=1
    if nc==b:
        a+=1
        nc=0
print(th)