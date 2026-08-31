from sys import stdin

def input():
    return stdin.buffer.readline()

t = int(input())
for _ in range(t):
    n = int(input())
    txt = list(map(int, input().split()))
    mmax = txt[0]
    c = 0
    mi = 0
    m = [0, 0, 0]
    for i in range(0, n//2):
        if txt[i] == mmax:
            c += 1
        else:
            mmax = txt[i]
            m[mi] += c
            c = 1
            if (m[mi] > m[0] and mi==1) or mi==0:
                mi += 1
    if txt[n//2]!=txt[n//2-1]:
        m[2] += c
    for i in range(len(m)):
        if m[i]==0:
            m = [0, 0, 0]
    if m[2]<=m[0] or m[1]<=m[0]:
        m = [0, 0, 0]
    for i in range(len(m)):
        print(m[i], end=' ')
    print()

