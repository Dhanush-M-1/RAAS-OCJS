from sys import stdin, stdout
import math

q = int(stdin.readline())
for x in range(q):
    z = int(stdin.readline())
    a = [int(b) for b in stdin.readline().split()]
    dif = 0
    for each in range(len(a)-1):
        temp = abs(a[each+1] - a[each])
        if a[each] != -1 and a[each+1] != -1:
            if temp > dif:
                dif = temp
    #print(dif)

    exist1 = []
    for i in range(len(a)):
        if i == 0:
            if a[i] != -1 and (a[i+1] == -1):
                exist1.append(a[i])
        elif i == len(a)-1:
            if a[i] != -1 and (a[i-1] == -1):
                exist1.append(a[i])
        else:
            if a[i] != -1 and (a[i-1] == -1 or a[i+1] == -1):
                exist1.append(a[i])

    #print(exist1)
    exist1.sort()
    #print(exist1)
    if not(len(exist1) == 0):
        m = math.ceil(((exist1[-1] - exist1[0]) / 2))
        k = m + exist1[0]
        #print(m, k)
    else:
        k = 0
        m = 0
    if dif > m:
        m = dif
    print(m, k)
