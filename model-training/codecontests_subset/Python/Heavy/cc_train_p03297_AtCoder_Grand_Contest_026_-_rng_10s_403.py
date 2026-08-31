import sys
input = sys.stdin.readline

n = int(input())
C = [list(map(int,input().split())) for i in range(n)]

from fractions import gcd

for i in range(n):
    a = C[i][0]
    b = C[i][1]
    c = C[i][2]
    d = C[i][3]
    ng = 0

    e = 0  # 最初に補充が発生する直前の本数
    e0 = a - b
    e1 = ((c - a%b) // b) * b + a%b
    e = min(e0, e1)

    if e < 0 or b > d:
        ng = 1
    else:
        g = gcd(b, d)
        # print(c+1, b-1, g)
        if c+1 <= b-1 and (c - e) // g < (b-1 - e) // g:
            ng = 1

    if ng == 1:
        print("No")
    else:
        print("Yes")
        