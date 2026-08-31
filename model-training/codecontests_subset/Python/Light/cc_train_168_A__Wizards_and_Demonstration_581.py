import math
n,w,p=list(map(int,input().split()))
m=math.ceil((n*p)/100)
if w>=m:
    print("0")
else:
    print(m-w)
