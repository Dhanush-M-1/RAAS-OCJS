def del_ev(a):
    for i in range(len(a)):
        if a[i] % 2 == 0:
            a.pop(i)
            return 0
    return 1

def del_od(a):
    for i in range(len(a)):
        if a[i] % 2 == 1:
            a.pop(i)
            return 0
    return 1

import copy

n = int(input())

a = list(map(int, input().split()))

sum_ev = 0
sum_od = 0

a.sort(reverse = True)
b = a.copy()

while(True):
    if(del_ev(a)):
        sum1 = sum(a)
        break
    if(del_od(a)):
        sum1 = sum(a)
        break
while(True):
    if(del_od(b)):
        sum2 = sum(b)
        break
    if(del_ev(b)):
        sum2 = sum(b)
        break
print(min(sum1, sum2))