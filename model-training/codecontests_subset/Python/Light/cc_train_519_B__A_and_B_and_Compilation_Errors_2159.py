#coding=utf-8

n = int(input().strip())
l1 = sorted(list(map(int, input().strip().split())))
l2 = sorted(list(map(int, input().strip().split()))) + ['x']
l3 = sorted(list(map(int, input().strip().split()))) + ['x', 'x']
res = [0, 0]
for i in range(len(l1)):
    if res[0] == 0:
        if l2[i] != l1[i]:
            res[0] = l1[i]
    if res[1] == 0:
        if l3[i] != l2[i]:
            res[1] = l2[i]
    if res[0] != 0 and res[1] != 0:
        break
for i in res:
    print(i)












