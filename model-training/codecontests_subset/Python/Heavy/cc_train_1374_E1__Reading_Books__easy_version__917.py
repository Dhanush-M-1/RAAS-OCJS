import sys
input = sys.stdin.readline
from  math import ceil

(n, k) = map(int, input().split())
Bob = []
Alice = []
Together = []
for i in range(n):
    (t, a, b) = map(int, input().split())
    if a*b == 1:
        Together.append(t)
    elif a == 1:
        Alice.append(t)
    elif b == 1:
        Bob.append(t)

if (len(Bob) + len(Together) < k) or (len(Alice) + len(Together) < k):
    print(-1)
    exit()

Bob.sort()
Alice.sort()
Together.sort()
a = 0
b = 0
t = 0
T = 0
Total_Bob = 0
Total_Alice = 0
while Total_Bob < k or Total_Alice < k:
    if Total_Alice < k and Total_Bob < k:
        if t < len(Together) and a < len(Alice) and b < len(Bob):
            if Together[t] < Alice[a] + Bob[b]:
                T += Together[t]
                t += 1
                Total_Alice += 1
                Total_Bob += 1
            else:
                T += Alice[a]
                T += Bob[b]
                a += 1
                b += 1
                Total_Alice += 1
                Total_Bob += 1
        elif t >= len(Together):
            T += Alice[a]
            T += Bob[b]
            a += 1
            b += 1
            Total_Alice += 1
            Total_Bob += 1
        else:
            T += Together[t]
            Total_Alice += 1
            Total_Bob += 1
            t += 1


    elif Total_Alice < k:
        if t < len(Together) and a < len(Alice):
            if Together[t] < Alice[a]:
                T += Together[t]
                t += 1
                Total_Alice += 1
                Total_Bob += 1
            else:
                T += Alice[a]
                a += 1
                Total_Alice += 1
        elif t >= len(Together):
            T += Alice[a]
            a += 1
            Total_Alice += 1
        else:
            T += Together[t]
            t += 1
            Total_Alice += 1
            Total_Bob += 1
    else:
        if t < len(Together) and b < len(Bob):
            if Together[t] < Bob[b]:
                T += Together[t]
                Total_Bob += 1
                t += 1
                Total_Alice += 1
            else:
                T += Bob[b]
                Total_Bob += 1
                b += 1
        elif t >= len(Together):
            T += Bob[b]
            Total_Bob += 1
            b += 1
        else:
            T += Together[t]
            Total_Bob += 1
            t += 1
            Total_Alice += 1





print(T)


