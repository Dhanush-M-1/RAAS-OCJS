n,x,y=map(int,input().split())
if (n*y)/100>(n*y)//100:
    reqad=((n*y)//100)+1
else:
    reqad=((n*y)//100)
ans=reqad-x
if ans<0:
    print(0)
else:
    print(ans)
