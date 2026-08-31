"""
arr = list(map(int, input().split()))
n,k=map(int, input().split())
"""
cases = int(input())
for _ in range(cases):
    size = int(input())
    lst = []
    for __ in range(size):
        arr = tuple(map(int, input().split()))
        lst.append(arr)
    if lst[0][0] < lst[0][1]:
        print('NO')
    else:
        flag = True
        for i in range(1, size):
            clear_diff = lst[i][1] - lst[i-1][1]
            if lst[i][0] - lst[i-1][0] < 0 or clear_diff < 0:
                print('NO')
                flag = False
                break
            elif lst[i][0] - lst[i-1][0] < clear_diff:
                print('NO')
                flag = False
                break
            else:
                continue
        if flag:
            print('YES')