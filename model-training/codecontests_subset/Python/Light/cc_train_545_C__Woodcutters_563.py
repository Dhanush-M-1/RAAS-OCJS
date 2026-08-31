rows = int(input())
if rows == 1:
    print(1)
    exit()
lst = []
c = 2
for i in range(rows):
    lst.append(list(map(int, input().split())))
for i in range(1, rows - 1):
    if lst[i][0] - lst[i][1] > lst[i - 1][0]:
        c += 1
    elif sum(lst[i]) < lst[i + 1][0]:
        lst[i][0] = sum(lst[i])
        c += 1

print(c)
