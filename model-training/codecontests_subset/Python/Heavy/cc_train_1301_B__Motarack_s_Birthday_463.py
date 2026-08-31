'''input
7
5
-1 10 -1 12 -1
5
-1 40 35 -1 35
6
-1 -1 9 -1 3 -1
2
-1 -1
2
0 -1
4
1 -1 3 -1
7
1 -1 7 5 2 -1 5
'''


def max_diff(a, mid):
    for i in range(len(a)):
        if a[i] == -1:
            a[i] = mid

    max_dif = 0
    for i in range(len(a) - 1):
        max_dif = max(max_dif, abs(a[i] - a[i + 1]))
        # print("here", mid, max_dif)

    return max_dif


for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))

    l = 0
    r = 10 ** 9

    while l < r:
        mid = (l + r) // 2
        max_dif = max_diff(a[::], mid)
        prev = max_diff(a[::], mid - 1)
        next = max_diff(a[::], mid + 1)

        if max_dif <= prev and max_dif <= next:
            l = r = mid
        elif prev < max_dif:
            r = mid - 1
        else:
            l = mid + 1
    print(max_diff(a[::], r), r)
    # print(a)
