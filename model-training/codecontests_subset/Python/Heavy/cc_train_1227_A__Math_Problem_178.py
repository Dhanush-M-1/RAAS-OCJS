def read():
    n = int(input())
    a = []
    for i in range(n):
        start, end = map(int, input().split())
        a.append((start, end))
    return n, a


def solve(n, a):
    # if n == 1:
    #     return 0
    a.sort(key=lambda p: p[0], reverse=True)
    last_start = a[0][0]
    a.sort(key=lambda p: p[1])
    first_end = a[0][1]
    # start, end = a[0]
    # for i in range(1, n):
    #     start_i, end_i = a[i]
    #     if start < start_i:
    #         start = start_i if start_i <= end else end
    #     if start_i > end:
    #         end = start_i
    if last_start > first_end:
        return last_start - first_end
    else:
        return 0


for i in range(int(input())):
    result = solve(*read())
    print(result)