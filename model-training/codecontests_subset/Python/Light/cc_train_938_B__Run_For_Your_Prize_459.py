# bsdk idhar kya dekhne ko aaya hai, khud kr!!!
# import math
# from itertools import *
# import random
# import calendar
# import datetime
# import webbrowser


n = int(input())
arr = list(map(int, input().split()))
lst = [0]*(10**6)
for i in arr:
    lst[i] = min(abs(i - 1), abs(10**6 - i))
print(max(lst))
