n = int(input())
coor = []
hight = []
for i in range(n):
    x, h = map(int, input().split())
    coor.append(x)
    hight.append(h)
if n <= 2:
    res = n
else:
    res = 2
for i in range(1, n - 1):
    if coor[i] - hight[i] > coor[i - 1]:
        res += 1
    else:
        if coor[i] + hight[i] < coor[i + 1]:
            res += 1
            coor[i] += hight[i]
print(res) 
        