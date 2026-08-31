a,b=map(int,input().split())
c,d=0,0
while(a>0):
    c=c+a
    d=d+a
    a=d//b
    d=d%b
print(c)