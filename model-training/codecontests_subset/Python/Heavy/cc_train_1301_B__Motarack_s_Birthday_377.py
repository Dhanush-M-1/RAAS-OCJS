import math
def mb(arr):
    negs = 0
    mini = math.inf
    maxi = -math.inf
    all_neg = True
    for i in range(len(arr)-1):
        if arr[i] != -1 and arr[i+1] == -1:
            mini = min(mini, arr[i])
            maxi = max(maxi, arr[i])
            all_neg = False
        if arr[i] == -1 and arr[i+1] != -1:
            mini = min(arr[i+1], mini)
            maxi = max(arr[i+1], maxi)
            all_neg = False
    if all_neg:
        return 0, 42
    avg = (mini+maxi)//2
    min_tax = 0
    for i in range(len(arr)-1):
        l, r = arr[i], arr[i+1]
        if l == -1:
            l = avg
        if r == -1:
            r = avg
        min_tax = max(abs(r-l), min_tax)
    return min_tax, avg

t = int(input())
for _t in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    ans = mb(arr)
    print(str(ans[0]) + " " + str(ans[1]))