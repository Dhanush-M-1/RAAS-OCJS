import sys

def input():
    return sys.stdin.readline().strip()

t = int(input())

for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))
    dif = 0
    diffs = []
    for i in range(1,len(arr)):
        if arr[i] == -1:
            if arr[i-1] != -1:
                diffs.append(arr[i-1])
        else:
            if arr[i-1] == -1:
                diffs.append(arr[i])
            else:
                dif=max(abs(arr[i]-arr[i-1]),dif)
    k = 0
    if len(diffs)>0:
        mn = min(diffs)
        mx = max(diffs)
        k = mn+(mx-mn)//2
    for diff in diffs:
        dif=max(abs(k-diff),dif)
    print(dif,k)
