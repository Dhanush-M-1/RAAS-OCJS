#coding: utf-8
n, m = (int(i) for i in input().split())
allint = {}
for i in range(1, n+1):
    doButton = [int(j) for j in input().split()]
    for b in range(1, len(doButton)):
        allint.update({doButton[b]:0})
if (len(allint) == m):
    print("YES")
else:
    print("NO")