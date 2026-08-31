n = int(input())
tree = list()

for i in range(n):
    tree.append(list(map(int, input().split())))
#tree == x , h
# ans = [a]  a = -1 - влево, a = 1- вправо , a = 0 на месте
ans = [0] * (n + 1)
ans[0] = [-1]

for i in range(1, n-1):
    if ans[i-1] == 1:
        if tree[i-1][0] + tree[i-1][1] < tree[i][0] - tree[i][1]:
            ans[i] = -1
        elif tree[i][0] + tree[i][1] < tree[i+1][0]:
            ans[i] = 1
    else:
        if tree[i-1][0] < tree[i][0] - tree[i][1]:
            ans[i] = -1
        elif tree[i][0] + tree[i][1] < tree[i + 1][0]:
            ans[i] = 1
ans[-1] = 1
k = 0
for i in range(n):
    if ans[i] == 0:
        k += 1
if n == 1:
    print(1)
else:
    print(n-k+1)