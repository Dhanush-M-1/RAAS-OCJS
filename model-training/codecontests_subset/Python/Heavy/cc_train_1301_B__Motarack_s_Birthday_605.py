m = int(input())
import math
for _ in range(m):
    n = int(input())
    lst1 = list(map(int,input().split()))
    max_,min_ = 0,10**9+10
    ct = 0
    for i in range(n):
        if i > 0 and lst1[i] == -1 and lst1[i-1] != -1:
            max_ = max(max_,lst1[i-1])
            min_ = min(min_,lst1[i-1])
        if i < n-1 and lst1[i] == -1 and lst1[i+1] != -1:
            max_ = max(max_,lst1[i+1])
            min_ = min(min_,lst1[i+1])
    mid = math.ceil((max_+min_)/2)
    abs_ = 0
    for i in range(n):
        if not i:
            bef = lst1[i] if lst1[i] != -1 else mid
            continue
        if lst1[i] == -1:
            abs_ = max(abs_,abs(mid - bef))
            bef = mid
        else:
            abs_ = max(abs_,abs(lst1[i] - bef))
            bef = lst1[i]
    print(abs_,mid)


