n,x,y = map(int,input().split())
per = (y/100)*n
if per-x < 0:
    print(0)
elif per == int(per):
    print(int(per-x))
else:
    print(int(int(per)-x+1))