n, m = [int(x) for x in input().split()]
ls=[0]*m
for _ in range(n):
    lt = [int(x) for x in input().split()]
    for i in range(1, len(lt)):
        ls[lt[i]-1] = 1
if 0 in ls: print("NO")
else:print("YES")