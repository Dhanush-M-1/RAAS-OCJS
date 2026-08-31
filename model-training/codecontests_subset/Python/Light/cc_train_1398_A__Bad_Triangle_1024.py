import math
import sys
import re

n = int(input())
for x in range(n):
    l = int(input())
    a = list(map(int , input().rstrip().split()))
    if a[0] + a[1] > a[-1]:
        print(-1)
    else:
        print(1,2,l)