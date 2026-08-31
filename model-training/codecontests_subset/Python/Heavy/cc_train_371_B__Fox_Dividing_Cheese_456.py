
from collections import deque , Counter
from math import sqrt
def primefac(n):
    d = deque()
    while n % 2 == 0 :
        n//=2
        d.append(2)

    for j in range(3 , int(sqrt(n)) + 1  ):
        while n % j == 0 :
            n//= j
            d.append(j)

    if n > 2 :
        d.append(n)
    return d
n , m = map(int,input().split())
if n == m :
    print(0)
    exit(0)

r1 = (primefac(n))
r2 = (primefac(m))
#print(r1)
#print(r2)

r1 = list(r1)
r2 = list(r2)

cnt1 , cnt2 = 0 , 0
flag = True
x , y = Counter(r1) , Counter(r2)
#print(x)
#print(y)

for i in x.keys():
    if i in y.keys() and x[i] != y[i]:
        if i % 2 == 0 or i % 3 == 0 or i % 5 == 0 :
            cnt1 += abs(x[i] - y[i])
        else:
            flag = False
            break
    elif i not in y.keys():
        if i % 2 == 0 or i % 3 == 0 or i % 5 == 0 :
            cnt1 += x[i]
        else:
            flag = False
            break

if flag == False:
    print(-1)
    exit(0)

for i in y.keys():
    if i not in x.keys():
        if i % 2 == 0 or i % 3 == 0 or i % 5 == 0 :
            cnt2 += y[i]
        else:
            flag = False
            break

if flag == False:
    print(-1)
    exit(0)

print(cnt1 + cnt2)
