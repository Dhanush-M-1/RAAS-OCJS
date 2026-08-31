a,b=map(int,input().split())
t=0
while a>0:
    t=t+1
    a=a-1
    if t%b==0:
        a=a+1
print(t)