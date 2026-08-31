from math import *
def chop():
    return (int(i) for i in input().split())
a=input()
b=int(input())
ab=[]
for i in range(b):
    ab.append(input())
slog=[]
for i in range(b):
    slog.append(ab[i])
for i in range(b):
    cur=ab[i][0];
    for j in range(b):
        if j!=i:
            slog.append(ab[j][1]+cur)
for i in range(b):
    cur=ab[i][1]
    for j in range(b):
        slog.append(cur+ab[j][0])
print('YES' if a in slog else 'NO')
