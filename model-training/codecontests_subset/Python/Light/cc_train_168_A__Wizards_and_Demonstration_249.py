import math
n,x,y=[int(x) for x in input().split()]
ans=int(math.ceil((y*n)/100))
cnt=ans-x
if(cnt<0):
    print("0")
else:
    print(cnt)