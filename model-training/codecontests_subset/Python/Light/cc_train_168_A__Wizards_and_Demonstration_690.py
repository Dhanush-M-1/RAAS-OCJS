n,x,y = map(int,input().split())
import math
if((x/n)*100>=y):
    print(0)
else:
    z = math.ceil((y*n)/100)
    print(z-x)