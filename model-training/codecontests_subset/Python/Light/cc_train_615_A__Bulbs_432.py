n, m = map(int, input().split())
tmpList = [item for item in range(1, m+1)]
for i in range(n):
    x = list(map(int, input().split()))
    for j in range(1, len(x)):
        if x[j] in tmpList:
            tmpList.remove(x[j])
print('YES' if len(tmpList) == 0 else 'NO')
