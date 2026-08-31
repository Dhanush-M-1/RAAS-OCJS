row = list(map(int, input().strip().split()))
col = list(map(int, input().strip().split()))
diag = list(map(int, input().strip().split()))
(r1, r2) = (row[0], row[1])
(c1, c2) = (col[0], col[1])
(d1, d2) = (diag[0], diag[1])
lst = [[(r1 + c1 - d2) / 2, (d2 + r1 - c1) / 2], [(d2 + c1 - r1) / 2, (2*c2 + c1 - d2 - r1) / 2]]
val = True
for item in lst:
    if item[0] not in [1, 2, 3, 4, 5, 6, 7, 8, 9] or item[1] not in [1, 2, 3, 4, 5, 6, 7, 8 , 9] or item[0] == item[1]:
        val = False
        break
    else:
        item[0] = int(item[0])
        item[1] = int(item[1])
if lst[0][0] == lst[1][0] or lst[0][1] == lst[1][1] or lst[0][0] == lst[1][1] or lst[0][1] == lst[1][0] or (r1 + r2) != (c1 + c2):
    val = False
if val:
    for item in lst:
        print(item[0], item[1])
else:
    print(-1)