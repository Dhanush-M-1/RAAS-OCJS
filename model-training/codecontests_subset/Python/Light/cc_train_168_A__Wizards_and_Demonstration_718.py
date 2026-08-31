import math
n , x , y = map(int,input().split())
a =((n*y)/100)
if round(a)>a:
    a=round(a)
if round(a)<a:
    a=round(a)+1
if x == a:
    print('0')
elif a-x>=0:
    print(int((a-x)))
else:
    print('0')