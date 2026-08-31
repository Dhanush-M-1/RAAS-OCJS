import math
from decimal import *
import random

for _ in range(int(input())):
    left, right, d = map(int, input().split())
    if(d==1 and left>1):
        print(1)
    elif(d==1 and left==1):
        print(right+1)
    elif(left<=d*1):
        print(math.ceil((right+1)/d)*d)
    else:
        print(d)
