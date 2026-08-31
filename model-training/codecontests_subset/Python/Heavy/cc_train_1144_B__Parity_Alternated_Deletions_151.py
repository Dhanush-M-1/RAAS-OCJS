# bsdk idhar kya dekhne ko aaya hai, khud kr!!!
# import math
# from itertools import *
# import random
# import calendar
# import datetime
# import webbrowser

n = int(input())
arr = list(map(int, input().split()))
even = []
odd = []
for i in arr:
    if i % 2 == 0:
        even.append(i)
    else:
        odd.append(i)
even.sort(reverse=True)
odd.sort(reverse=True)
if len(odd) > len(even):
    sum_ = sum(odd[len(even)+1:])
    print(sum_)
elif len(odd) < len(even):
    sum_ = sum(even[len(odd)+1:])
    print(sum_)
else:
    print(0)
