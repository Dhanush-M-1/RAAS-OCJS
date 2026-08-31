import math as m
n,x,y=map(int,input().split())
if (x/n)*100>=y:
    print(0)
else:
    ans=m.ceil((n*y)/100)-x
    print(ans)
