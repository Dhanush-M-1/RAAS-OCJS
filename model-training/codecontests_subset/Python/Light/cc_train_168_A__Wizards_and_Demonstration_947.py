import math
n,x,y = map(int,input().split())
req = int(math.ceil((n*y)/100))
if x>req:
    print (0)
else:
    print (req-x)