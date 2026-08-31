import sys 
# from itertools import
# from collections import deque
import math
# from bisect import bisect

# input = sys.stdin.buffer.readline
input = sys.stdin.readline
  
q = int(input())
# x = [int(_) for _ in input.split()]
# n, k = map(int, input().split())
def sol (arr , mm):
    
    z = [a if a!=-1 else mm for a in arr ]
    maxdiff = 0 
    for i in range(len(z)-1):
        diff = abs(z[i] - z[i+1])
        maxdiff = max(maxdiff,diff)
    return maxdiff

for _ in range(q):
    n = int(input())
    
    x = [int(_) for _ in input().split()]
    nums = list()

    for i in range(len(x)-1):
        if (x[i] ==-1) != (x[i+1] == -1) :
            nums.append(x[i]*x[i+1]*(-1))
    # print(nums)
    
    if not nums:
        mean = 0
    else:
        # mean=(sum(nums)/len(nums))
        # nums.sort()
        # print(f"{nums=}")
        mean = max(nums)/2 + min(nums)/2
        # if len(nums)%2==1:
            # mean = (nums[len(nums)//2])
        # else:
            # mean = nums[len(nums)//2]/2 + nums[len(nums)//2 -1]/2 
        # print(f"{mean=}")
    
    

    asol = math.ceil(mean)
    bsol = math.floor(mean)
    axax = sol(x, asol)
    bxbx = sol(x, bsol)

    
    if axax<bxbx:
        print(axax, asol)
    else:
        print(bxbx, bsol)
    # print("/"*100)
