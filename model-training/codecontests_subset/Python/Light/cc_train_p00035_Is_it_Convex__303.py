import sys
def angleis(p1, p2):
    return True if p1[0] * p2[1] - p1[1] * p2[0] > 0 else False

Ps = sys.stdin.readlines()
for P in Ps:
    xa, ya, xb, yb, xc, yc, xd, yd = map(float, P.split(','))
    p = [[xb-xa, yb-ya],[xc-xb, yc-yb],[xd-xc, yd-yc],[xa-xd, ya-yd],[xb-xa, yb-ya]]
    a = []
    for i in range(4):
        a.append(angleis(p[i], p[i+1]))
    if a.count(True) == 0 or a.count(True) == 4:
        print('YES')
    else :
        print('NO')