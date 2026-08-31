n,x,y=map(int,input().split())
if n*y%100==0 and int(n*y/100)<=x: print(0)
elif n*y%100!=0 and int(n*y/100)+1<=x: print(0)
else:
    if n*y%100==0: print(int(n*y/100)-x)
    else: print(int(n*y/100)+1-x)