import collections, math

local = False
if local:
    file = open("inputt.txt", "r")

def inp():
    if local:
        return file.readline().rstrip()
    else:
        return input().rstrip()

def ints():
    return [int(_) for _ in inp().split()]


t = int(inp())

for _ in range(t):
    n, m = ints()
    arr = inp()
    parr = ints()

    vals = []
    latest = [0]*26

    for a in arr:
        vals.append(list(latest))
        vals[-1][ord(a)-ord('a')] += 1

        latest = vals[-1]

    latest = [0]*26
    for p in parr:
        for i in range(26):
            latest[i] += vals[p-1][i]

    for i in range(26):
        latest[i] += vals[-1][i]

    print(" ".join([str(x) for x in latest]))
    
