from sys import stdin, stdout

n,m = map(int,stdin.readline().split())
arr = [0 for i in range(m)]
for i in range(n):
    line = stdin.readline().split()
    del line[0]
    for i in line:
        arr[int(i) - 1] = 1
ans = True
for i in arr:
    if i == 0:
        ans = False
        break
if ans:
    print("YES")
else:
    print("NO")
