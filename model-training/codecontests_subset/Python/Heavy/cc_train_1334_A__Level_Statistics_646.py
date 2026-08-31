def solve(lst):

    for i in range(len(lst)):
        a, b = lst[i][0], lst[i][1]
        if a < b:
            return False
        if i > 0 and (lst[i][0] < lst[i - 1][0] or lst[i][1] < lst[i - 1][1]):
            return False
        if i > 0 and 0 <= lst[i][0] - lst[i-1][0] < lst[i][1] - lst[i-1][1]:
            return False
    return True


m = int(input())


for i in range(m):
    n = int(input())
    lst = []
    for _ in range(n):
        a, b = list(map(int, input().split()))
        lst.append((a, b))
    if solve(lst):
        print('YES')
    else:
        print('NO')
