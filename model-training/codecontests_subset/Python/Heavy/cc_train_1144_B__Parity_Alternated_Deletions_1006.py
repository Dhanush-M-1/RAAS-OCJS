n = int(input())
a = []
b = []
for i in list(map(int,input().split())):
    if i%2:
        a.append(i)
    else:
        b.append(i)
a.sort()
b.sort()
s = sum(a)+sum(b)
i = len(a)-1
j = len(b)-1
while True:
    if i>=0:
        s -= a[i]
        i -= 1
    else:
        break
    if j>=0:
        s -= b[j]
        j -= 1
    else:
        break
s1 = sum(a)+sum(b)
i = len(a)-1
j = len(b)-1
while True:
    if j>=0:
        s1 -= b[j]
        j -= 1
    else:
        break
    if i>=0:
        s1 -= a[i]
        i -= 1
    else:
        break
print(min(s,s1))
