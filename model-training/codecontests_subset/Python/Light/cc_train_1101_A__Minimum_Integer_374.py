import math
q = int(input())
q1 = list(range(q))
for i in range(0,q):
    temp = map(int,input().split(' '))
    l, r, d = temp
    k = d
    if k >= l and k <= r:
        for j in range(0,math.ceil(r/l)):
            t1 = r % k
            k = r + k - t1
            if k > r:
                break
    q1[i] = k
for i in range(0,q):
    print(q1[i])