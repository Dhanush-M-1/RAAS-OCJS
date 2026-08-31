def function(n, nums):
    if nums[0]+nums[1]<=nums[-1]:
        return f'{1} {2} {len(nums)}'
    else:
        return -1


if __name__=="__main__":
    t=int(input())
    for k in range(t):
        n=int(input())
        nums=list(map(int, input().rstrip().split()))
        print(function(n, nums))