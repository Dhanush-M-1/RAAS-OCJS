# bsdk idhar kya dekhne ko aaya hai, khud kr!!!
# from math import *
# from itertools import *
# import random
n, m = map(int, input().split())
bulbs = []
for i in range(n):
    arr = list(map(int, input().split()))
    arr.pop(0)
    for j in arr:
        bulbs.append(j)
if len(list(dict.fromkeys(bulbs))) == m:
    print("YES")
else:
    print("NO")
