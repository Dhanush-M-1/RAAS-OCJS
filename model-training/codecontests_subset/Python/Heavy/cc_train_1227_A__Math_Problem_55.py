class Coord:
    def __init__(self, a, b):
        self.a = a
        self.b = b


ans = []
am1 = int(input())
for i in range(am1):
    c = 0
    am2 = int(input())
    ar = []
    for j in range(am2):
        stop = False
        a, b = map(int, input().split())
        nc = Coord(a, b)
        k = 0
        while k < c and not stop:
            if not ((ar[k].a > nc.b) or (ar[k].b < nc.a)):
                ar[k].a = max(ar[k].a, nc.a)
                ar[k].b = min(ar[k].b, nc.b)
                stop = True
            k += 1
        if not stop:
            ar.append(nc)
            c += 1
    if c!= 1:
        mi = ar[0].b
        ma = ar[0].a
        for j in range(c):
            if ar[j].b <= mi:
                mi = ar[j].b
            if ar[j].a >= ma:
                ma = ar[j].a
        ans.append(abs(ma-mi))
    else:
        ans.append(0)
for i in range(am1):
    print(ans[i])