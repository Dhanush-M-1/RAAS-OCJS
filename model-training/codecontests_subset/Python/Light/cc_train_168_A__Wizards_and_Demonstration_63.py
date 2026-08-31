import math
a,b,c=map(int,input().split())
print(math.ceil((a*c)/100-b) if math.ceil((a*c)/100-b)>0 else 0)
