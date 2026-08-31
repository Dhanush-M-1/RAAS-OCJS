import math, collections, sys
input = sys.stdin.readline
# def check(a, val, finalRange):
#     valrange = [0, 10**9]
#     r = [0, 10**9]
#     for i in range(1, len(a)):
#         if a[i]!=-1 and a[i-1]!=-1:
#             if abs(a[i]-a[i-1]) > val:
#                 return False
#             if a[i] == -1:
#                 r = [max(a[i-1] - val, 0), min(a[i-1] + val, 10**9)]
#             elif a[i-1] == -1:
#                 r = [max(a[i] - val, 0), min(a[i] + val, 10**9)]
#         valrange = [max(valrange[0], r[0]), min(valrange[1], r[1])]
#     print(valrange)
#     if valrange[0] <= valrange[1]:
#         finalRange = valrange
#         return True
#     return False
# def binary_search(lo, hi, a, finalRange):
#     while lo < hi:
#         mid = lo + (hi-lo)//2
#         # print(mid)
#         if check(a, mid, finalRange):
#             hi = mid
#         else:
#             lo = mid+1
#     return lo
def case():
    n = int(input())
    a = list(map(int, input().split()))
    l = []
    for i in range(1, n):
        if a[i] == -1 and a[i-1] != -1:
            l.append(a[i-1])
        if a[i-1] == -1 and a[i] != -1:
            l.append(a[i])
    if not l:
        k = 1
    else:
        k = (max(l) + min(l))//2
    diff = []
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    for i in range(1, n):
        diff.append(abs(a[i]-a[i-1]))
    print(max(diff), k)
    # finalRange = []
    # diff = binary_search(0, 10**9+1, a, finalRange)
    # print(diff, finalRange[0])
for _ in range(int(input())):
    case()