import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
ls = list(map(int, input().split()))
ls.sort()
arr = []
elem = {}
minSteps = {}
for x in range(ls[-1]+1):
    elem[x] = 0
    minSteps[x] = 0
for i in ls:
    steps = 0
    while i!=0:
        if elem[i]!=k:
            elem[i]+=1
            minSteps[i]+=steps
        i//=2
        steps+=1
    if elem[i]!=k:
        elem[i]+=1
        minSteps[i]+=steps
m = 1000000000000
for key, value in elem.items():
    if value==k:
        m = min(m, minSteps[key])
print(m)
