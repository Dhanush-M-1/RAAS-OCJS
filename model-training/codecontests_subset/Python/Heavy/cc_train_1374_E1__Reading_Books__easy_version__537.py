from collections import deque

n, k = list(map(int, input().split()))
both_ls = []
a_ls = []
b_ls = []
for i in range(n):
    t, a, b = list(map(int, input().split()))
    if a == 1 and b == 0:
        a_ls.append(t)
    elif a == 0 and b == 1:
        b_ls.append(t)
    elif a == 1 and b == 1:
        both_ls.append(t)
a_ls = sorted(a_ls)
b_ls = sorted(b_ls)
both_ls = sorted(both_ls)
a_ls = deque(a_ls)
b_ls = deque(b_ls)
both_ls = deque(both_ls)

res = 0
broke = False

for i in range(k):
    if len(both_ls)>0 and len(a_ls)>0 and len(b_ls)>0:
        if both_ls[0] >= (a_ls[0] + b_ls[0]):
            res += a_ls.popleft()
            res += b_ls.popleft()
        else:
            res += both_ls.popleft()
    elif len(both_ls)>0:
        res += both_ls.popleft()
    elif len(a_ls)>0 and len(b_ls)>0:
        res += a_ls.popleft()
        res += b_ls.popleft()
    else:
        print(-1)
        broke = True
        break

if not broke:
    print(res)