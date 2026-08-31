# A and B and Compilation Errors 
import queue
n = int(input())
er1 = list(map(int, input().split()))
er2 = list(map(int, input().split()))
er3 = list(map(int, input().split()))
er1.sort()
er2.sort()
er3.sort()
a = er1[len(er1) - 1]
b = er2[len(er2) - 1]
for i in range(len(er2)):
    if er1[i] != er2[i]:
        a = er1[i]
        break
for i in range(len(er3)):
    if er2[i] != er3[i]:
        b = er2[i]
        break
print(a)
print(b)