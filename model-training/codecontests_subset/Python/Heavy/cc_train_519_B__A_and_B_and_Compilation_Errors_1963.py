n = int(input())
a1 = input().split()
a2 = input().split()
a3 = input().split()
d1 = {}
d2 = {}
d3 = {}
r = []
for i in a3:
    if i in d3:
        d3[i] += 1
    else:
        d3[i] = 1
for i in a2:
    if i in d2:
        d2[i] += 1
    else:
        d2[i] = 1
    if i not in d3:
        r += [i]
    else:
        if d3[i] == 0:
            r += [i]
        else:
            d3[i] -= 1
for i in a1:
    if i not in d2:
        r += [i]
    else:
        if d2[i] == 0:
            r += [i]
        else:
            d2[i] -= 1
for i in r[::-1]:
    print(i)
