from collections import defaultdict
n = int(input())
first = sorted(list(map(int, input().split())))
second = sorted(list(map(int, input().split())))
third = sorted(list(map(int, input().split())))
n1,n2 = 0,0
t = 1
for i in range(n-1):
    if first[i] != second[i]:
        n1 = first[i]
        t = 0
        break
if t == 1:
    n1 = first[-1]
t = 1
for i in range(n-2):
    if second[i] != third[i]:
        n2 = second[i]
        t = 0
        break
if t == 1:
    n2 = second[-1]
print(n1)
print(n2)


