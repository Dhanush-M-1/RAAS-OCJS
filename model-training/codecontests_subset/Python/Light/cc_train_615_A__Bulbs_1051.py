n, m = map(int, input().split())
use = [0]*1000
for i in range(0, n):
    a = list(map(int, input().split()))
    for j in range(1, a[0]+1):
        use[a[j]] = 1;
flag = 1
for i in range(1, m+1):
    if (use[i] == 0):
        flag = 0
if (flag == 1):
    print("YES")
else:
    print("NO")