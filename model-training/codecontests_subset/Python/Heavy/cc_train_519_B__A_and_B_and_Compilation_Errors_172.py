n = int(input())

orig = list(map(int, input().split()))
second = list(map(int, input().split()))
third = list(map(int, input().split()))

orig.sort()
second.sort()
third.sort()

# def find_missing(orig, arr):
#     lo = 0
#     hi = len(arr)

#     while lo < hi:
#         mid = (lo + hi) // 2
#         print(lo, hi, mid, orig[lo])
#         if orig[mid] == arr[mid]:
#             lo = mid + 1
#             print("lo", lo)
#         else:
#             hi = mid
#             print("hi", hi)

#     print("res", lo, orig[lo])

#     return orig[lo]

# print("orig", *orig)
# print("second", *second)
# print("third", *third)

# print(find_missing(orig, second))
# print(find_missing(second, third))

ans1 = orig[-1]

for i in range(len(second)):
    if orig[i] != second[i]:
        ans1 = orig[i]
        break

print(ans1)

ans2 = second[-1]

for i in range(len(third)):
    if second[i] != third[i]:
        ans2 = second[i]
        break

print(ans2)
