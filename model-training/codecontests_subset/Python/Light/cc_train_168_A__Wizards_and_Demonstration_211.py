import math
n,x,y=map(int,input().split())
ReqPeople=math.ceil((y*n)/100)
if x<ReqPeople:
    print(ReqPeople-x)
else:
    print(0)