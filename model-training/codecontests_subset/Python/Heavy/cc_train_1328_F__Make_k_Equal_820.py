import sys
input = lambda: sys.stdin.readline().strip()

n, k = map(int, input().split())
ls = list(map(int, input().split()))
ls.sort()
arr = []
for i in ls:
    while i!=0:
        arr.append(i)
        i//=2
    arr.append(0)
arr = list(set(arr))
arr.sort()
cnts = []
m = 10000000000000000000
for x in arr:
    Cnt = 0
    S = 0
    for i in ls:
        cnt = 0
        while i>x:
            i//=2
            cnt+=1
        if i==x and Cnt<k: S+=cnt; Cnt+=1
    if Cnt==k: m = min(m, S)
print(m)
