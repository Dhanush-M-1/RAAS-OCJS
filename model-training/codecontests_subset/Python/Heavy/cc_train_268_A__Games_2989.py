n = int(input())
a = []
a_domach = []
a_gost = []
count = 0
for i in range(n):
    a.append(list(input().split()))
for j in range(1):
    for i in range(n):
        a_domach.append(a[i][j])
for j in range(1,2):
    for i in range(n):
        a_gost.append(a[i][j])
for ii in a_domach:
    for jj in a_gost:
        aa = a_domach.index(ii)
        bb = a_gost.index(jj)
        cc = a_domach[a_domach.index(ii)]
        dd = a_gost[a_gost.index(jj)]
        if a_domach.index(ii) != a_gost.index(jj) and ii == jj:
            count += 1
print(count)