import math
a, b = list(map(int, input().rstrip().split()))
g = math.gcd(a, b)
q1 = a // g
q2 = b // g
flag1 = 0
flag2 = 0
o = 0
while q1 != 1:
    if q1 % 5 == 0:
        q1 = q1 // 5
        o += 1
    elif q1 % 3 == 0:
        q1 = q1 // 3
        o += 1
    elif q1 % 2 == 0:
        q1 = q1 // 2
        o += 1
    else:
        flag1 = 1
        break
while q2 != 1:
    if q2 % 5 == 0:
        q2 = q2 // 5
        o += 1
    elif q2 % 3 == 0:
        q2 = q2 // 3
        o += 1
    elif q2 % 2 == 0:
        q2 = q2 // 2
        o += 1
    else:
        flag2 = 1
        break
if flag1 == 1 or flag2 == 1:
    print(-1)
else:
    print(o)