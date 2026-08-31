from math import ceil
#A. Wizards and Demonstration
n,x,y = map(int,input().split())
if x/n>=y/100:
    print(0)
else:
    b = (y/100)*n-x
    print(ceil(b))