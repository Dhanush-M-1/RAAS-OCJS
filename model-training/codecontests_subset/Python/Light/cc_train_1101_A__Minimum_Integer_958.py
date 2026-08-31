import math
n = int(input())
mtrx = [list(int(x) for x in input().split()) for i in range(n)]
for i in range(n):
    if mtrx[i][2] < mtrx[i][0]:
        print(mtrx[i][2])
    if mtrx[i][2] >= mtrx[i][0]:
        print(math.ceil((mtrx[i][1] + 1)/mtrx[i][2]) * mtrx[i][2])

