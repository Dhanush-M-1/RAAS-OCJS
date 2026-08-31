a,b=map(int,input().split())
t=a #new
r=0 #old
for i in range(1,2000):
    t=t-1
    r=r+1
    if r==b:
        t=t+1
        r=0
    if t==0:
        print(i)
        break
