c,b=map(int,input().split())
h=c
vc=c
while b<=vc:
    nc=vc//b
    vc=vc%b
    vc=vc+nc
    h+=nc
print(h)