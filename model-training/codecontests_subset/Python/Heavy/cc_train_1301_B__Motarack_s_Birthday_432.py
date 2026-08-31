from math import ceil
t = int(input())


def test(mid):
    m = 0
    # print(rep)
    for i in range(len(nums) - 1):
        p, p1 = nums[i] if i not in rep else mid, nums[i + 1] if i + 1 not in rep else mid
        # print(p,p1,i,i+1)
        if abs(p1 - p) > m:
            m = abs(p1 - p)
    return m




for i in range(t):
    n = int(input())
    nums = list(map(int, input().split()))

    ma = -1
    mi = 9999999999
    for i in range(len(nums)-1):
        p,p1 = nums[i], nums[i+1]
        if p==-1 and p1==-1:
            continue
        elif p==-1:
            if nums[i+1] < mi:
                mi = nums[i+1]
            if nums[i+1] > ma:
                ma = nums[i+1]
        elif p1==-1:
            if nums[i] < mi:
                mi = nums[i]
            if nums[i] > ma:
                ma = nums[i]
    if ma==-1 and mi==9999999999:
        print("0 0")
    else:
        for i in range(len(nums)):
            if nums[i]==-1:
                nums[i]=(ma+mi)//2
        res = 0
        ans = (ma+mi)//2
        for j in range(len(nums)-1):
            p,p2 = nums[j],nums[j+1]
            if abs(p2-p) > res:
                res = abs(p2-p)
        print(res, ans)


