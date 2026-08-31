n = int(input())
a = [int(i) for i in input().split()]
cntev = 0
cntodd = 0
even = []
odd  = []
for el in a:
    if el % 2 == 0:
        even.append(el)
    else:
        odd.append(el)
even.sort()
odd.sort()
s = 0
if abs(len(even) - len(odd)) < 2:
    print(0)
elif len(even) > len(odd):
    cnt = len(even) - len(odd)
    for i in range(cnt - 1):
        s += even[i]
    print(s)
elif len(even) < len(odd):
    cnt = len(odd) - len(even)
    for i in range(cnt - 1):
        s += odd[i]
    print(s)
