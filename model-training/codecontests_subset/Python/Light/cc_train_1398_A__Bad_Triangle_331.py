import sys
input = sys.stdin.readline
def inInt():
    return int(input())
def inStr():
    return input().strip("\n")
def inIList():
    return(list(map(int,input().split())))
def inSList():
    return(input().split())

def solve(n, nums):
    if nums[0] + nums[1] <= nums[len(nums)-1]:
        print(1, 2, len(nums))
    else:
        print("-1")
    

t = inInt()
for case in range(t):
    n = inInt()
    nums = inIList()
    solve(n, nums)