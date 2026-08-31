import sys
input = sys.stdin.readline

#Returns set prime factors O(sqrt(n))
import math
def primefactors(n):
    l = []
    while n % 2 == 0:
        l.append(2)
        n = n // 2

    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            l.append(i)
            n = n // i

    if n > 2:
        l.append(n)

    return l

a,b = map(int,input().split())
z1 = primefactors(a)
z2 = primefactors(b)
r1 = {}
r2 = {}

for i in z1:
    if i in r1:
        r1[i] += 1

    else:
        r1[i] = 1

for i in z2:
    if i in r2:
        r2[i] += 1

    else:
        r2[i] = 1


o = [2,3,5]
ans = 0
for i in range(2,6):
    if i == 4:
        continue

    else:
        e1 = 0
        e2 = 0
        if i in r1:
            e1 = r1[i]

        if i in r2:
            e2 = r2[i]

        ans += abs(e2-e1)

flag = 0
for i in r1:
    if i != 2 and i != 3 and i != 5:
        if i in r2:
            if r2[i] != r1[i]:
                flag = 1
                break

        else:
            flag = 1
            break

for i in r2:
    if i != 2 and i != 3 and i != 5:
        if i in r1:
            if r2[i] != r1[i]:
                flag = 1
                break

        else:
            flag = 1
            break

if flag:
    print(-1)

else:
    print(ans)