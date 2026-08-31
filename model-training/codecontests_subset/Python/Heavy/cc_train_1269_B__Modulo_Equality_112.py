import collections
import math

n, m = [int(s) for s in input().split()]
a = [int(s) for s in input().split()]
b = [int(s) for s in input().split()]
a.sort()
b.sort()
b = collections.deque(b)
def check(a, b):
    minus = b[0] - a[0]
    if minus < 0:
        x = minus + m
        minus2 = minus
    else:
        x = minus
        minus2 = x - m
    flag = 0
    for i in range(1,n):
        if b[i] - a[i] == minus:
            if flag:
                return False
        elif b[i] - a[i] == minus2:
            flag = 1
        else:
            return False
    return True

for i in range(n):
    if check(a, b):
        minus = b[0] - a[0]
        if minus < 0:
            x = minus + m
        else:
            x = minus
        print(x)
        break
    b.append(b.popleft())