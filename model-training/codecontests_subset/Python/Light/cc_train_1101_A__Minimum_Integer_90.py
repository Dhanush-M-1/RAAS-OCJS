# ===================================
# (c) MidAndFeed aka ASilentVoice
# ===================================
# import math 
# import collections
# import string
# ===================================
n = int(input())
for _ in range(n):
    l, r, d = [int(x) for x in input().split()]
    ans = d
    if l <= ans <= r:
        ans = (r+d-1) // d * d
        if ans == r:
            ans += d
    print(ans)