import sys
def ints():
    return list(map(int, sys.stdin.readline().strip().split()))
tc = int(input())
while tc:
    tc-=1
    s = input()
    k, n, m = map(int, input().split())
    ln = ints()
    lm = ints()
    op = []
    i, j = 0, 0
    while i<n and j<m:
        if ln[i] < lm[j]:
            op.append(ln[i])
            i += 1
        else:
            op.append(lm[j])
            j += 1
    while i<n:
        op.append(ln[i])
        i += 1
    while j<m:
        op.append(lm[j])
        j += 1
    flag = 0
    for item in op:
        if item == 0:
            k+=1
        elif item <= k:
            pass
        else:
            flag = 1
    if flag:
        print(-1)
    else:
        print(*op)