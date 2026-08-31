n, k = list(map(int, input().split()))
ar1 = []
ar2 = []
ar3 = []
for i in range(n):
    ar = list(map(int, input().split()))
    if ar[1] == 1 and ar[2] == 0:
        ar1.append(ar)
    elif ar[1] == 0 and ar[2] == 1:
        ar2.append(ar)
    elif ar[1] == ar[2] == 1:
        ar3.append(ar)

ar1.sort()
ar2.sort()
ar3.sort()
i, j, h = 0, 0, 0
num1, num2 = k, k
ans = 0
while ((i < len(ar1) and j < len(ar2)) or h < len(ar3)) and num1 > 0 and num2 > 0:
    if h >= len(ar3):
        ans += ar1[i][0] + ar2[j][0]
        i += 1
        j += 1
    elif i >= len(ar1) or j >= len(ar2):
        ans += ar3[h][0]
        h += 1
    elif ar1[i][0] + ar2[j][0] > ar3[h][0]:
        ans += ar3[h][0]
        h += 1
    else:
        ans += ar1[i][0] + ar2[j][0]
        i += 1
        j += 1
    num1 -= 1
    num2 -= 1
if num1 > 0 or num2 > 0:
    print(-1)
else:
    print(ans)
