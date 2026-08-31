#print(1909602029174-1517519866716)
import math
def function(n, nums_0, nums_1):
    if (max(nums_0)-min(nums_1))>=0:
        return max(nums_0)-min(nums_1)
    else:
        return 0
if __name__=="__main__":
    t=int(input())
    nums_0=[]
    nums_1=[]
    for k1 in range(t):
        n=int(input())
        for k2 in range(n):
            nums=list(map(int, input().rstrip().split()))
            nums_0.append(nums[0])
            nums_1.append(nums[1])
        print(function(n, nums_0, nums_1))
        nums_0=[]
        nums_1=[]
