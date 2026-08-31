n = int(input())
lst = []
for _ in range(n): lst.append(tuple(map(int, input().split(' '))))
res = min(2, n)
right_verge = lst[0][0]
for i in range(1, n-1, 1):
    if lst[i][0]-lst[i][1] > right_verge:
        res += 1
        right_verge = lst[i][0]
    elif lst[i][0]+lst[i][1] < lst[i+1][0]:
        res += 1
        right_verge = lst[i][0]+lst[i][1]
    else: right_verge = lst[i][0]
print(res)