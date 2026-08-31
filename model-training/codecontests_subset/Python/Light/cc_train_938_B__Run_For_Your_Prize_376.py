from bisect import bisect_left, bisect_right
n = int(input())
a = list(map(int, input().split()))
q = 500000
index_left = bisect_left(a, q)
index_right = bisect_right(a, q)
if q in a:
    print(499999)
elif len(a) == index_left:
    print(a[index_left - 1] - 1)
elif index_right == 0:
    print((10 ** 6) - a[index_left])
else:
    print(max(a[index_left - 1] - 1, (10 ** 6) - a[index_right]))