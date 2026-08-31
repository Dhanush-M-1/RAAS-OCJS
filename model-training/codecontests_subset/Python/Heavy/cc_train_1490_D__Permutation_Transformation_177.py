t = int(input())

def getmax(lst: list):
    ans = lst[0]
    for e in lst:
        if e > ans:
            ans = e
    return ans


def getmaxidx(a, arr):
    max_ = getmax(a)
    return arr.index(max_), max_

def maketree(left: list, right: list, depth, ans: list, arr):
    if len(left) == 0 and len(right) == 0:
        return
    # depth_ = depth
    if len(left) != 0:
        lstart, lmax = getmaxidx(left[:], arr)
        ans[lstart] = depth
        maketree(left[:left.index(lmax)], left[left.index(lmax)+1:], depth=depth+1, ans=ans, arr=arr)

    if len(right) != 0:
        rstart, rmax = getmaxidx(right[:], arr)
        ans[rstart] = depth
        maketree(right[:right.index(rmax)], right[right.index(rmax)+1:], depth=depth+1, ans=ans, arr=arr)


for _ in range(t):
    n = int(input())
    ans = [0] * n
    arr = list(map(int, input().split(' ')))
    start, max = getmaxidx(arr, arr)
    depth = 0
    ans[start] = depth

    maketree(arr[:start], arr[start+1:], depth=depth+1, ans=ans, arr=arr)

    print(*ans)








