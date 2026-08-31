import sys

s = sys.stdin.readline().split()
n, k = int(s[0]), int(s[1])
i = 1
arr11 = []
arr01 = []
arr10 = []
arr00 = []
while i <= n:
    s = input().split()
    s = list(map(int, s))
    if s[-1] == 0:
        if s[1] == 0:
            arr00.append(s[0])
        else:
            arr10.append(s[0])
    else:
        if s[1] == 0:
            arr01.append(s[0])
        else:
            arr11.append(s[0])
    i += 1
arr00.sort()
arr10.sort()
arr01.sort()
arr11.sort()
arr1001 = list(map(lambda x, y : x + y, arr01,arr10))
finallst = arr1001 + arr11
finallst.sort()
i = 0
ans = 0
if len(finallst) < k:
    ans = -1
    i = k
while i < k:
    ans = ans + finallst[i]
    i += 1
print(ans)
