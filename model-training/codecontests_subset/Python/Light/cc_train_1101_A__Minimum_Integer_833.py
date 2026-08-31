t = int(input())
L = []
R = []
D = []
for i in range(t):
    l, r, d = map(int, input().split())
    L.append(l)
    R.append(r)
    D.append(d)
for i in range(t):
    small = (L[i]/D[i])
    large = (R[i]/D[i])
    if small > 1.0:
        print(D[i])
    else:
        print((int(large) + 1)*D[i])


