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
    cnts = []
    for i in ls:
        cnt = 0
        while i>x:
            i//=2
            cnt+=1
        if i==x: cnts.append(cnt)
    cnts.sort()
    S = 0
    try:
        for i in range(k):
            S+=cnts[i]
        m = min(m, S)
    except: pass
print(m)
