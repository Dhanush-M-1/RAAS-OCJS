from math import factorial
from math import floor
n = int(input())
nums = input()
if '8' in nums:
    cm = min(floor(n/11), nums.count('8'))
    print(cm)
else: print(0)
