n,m = map(int,input().split())
lst = [0]*(m+1)
for i in range(n):
    lstn = list(map(int,input().split()))[1:]
    for j in lstn:
        lst[j]=1
count = lst.count(1)
if count==m:
    print('YES')
else:
    print('NO')