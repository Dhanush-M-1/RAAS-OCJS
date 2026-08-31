# Python program to print prime factors

import math

def primeFactors(n):
    factors = []
    while n % 2 == 0:
        factors.append(2)
        n = n / 2

    for i in range(3, int(math.sqrt(n)) + 1, 2):
        while n % i == 0:
            factors.append(i)
            n = n / i

    if n > 2:
        factors.append(int(n))
    return factors

def difference(li1, li2):
    dif = [i for i in li1 + li2 if i not in li1 or i not in li2]
    return dif

a, b = map(int, input().split())
l1 = primeFactors(a)
l2 = primeFactors(b)
l1_counts=[0]*3
l2_counts=[0]*3
for i in l1:
    if i==2: l1_counts[0]+=1
    elif i==3: l1_counts[1]+=1
    elif i==5: l1_counts[2]+=1
for i in l2:
    if i==2: l2_counts[0]+=1
    elif i==3: l2_counts[1]+=1
    elif i==5: l2_counts[2]+=1

#print(l1)
#print(l2)
x = difference(l1,l2)
#print(x)
for i in x:
    if i > 5:
        print(-1)
        exit(0)

answer = abs(l1_counts[0] - l2_counts[0]) + abs(l1_counts[1] - l2_counts[1]) + abs(l1_counts[2] - l2_counts[2])
print(answer)