t = int(input())
for test in range(t):
    i = int(input())
    lines = []
    minl = None
    minr = None
    for line in range(i):
        l, r = list(map(int, input().split()))
        if (minl == None):
            minl = r
            minr = r
        else:
            minr = min(minr, r)

        lines.append([l, r])
    for line in lines:
        if (minl == None or line[1] < minl):
            minl = line[1]
        if (minr == None or line[0] > minr):
            minr = line[0]
    print(minr - minl)