import collections, math, bisect, re

local = False
if local:
    file = open("input.txt", "r")
    import time

def inp():
    if local:
        return file.readline().rstrip()
    else:
        return input().rstrip()

def ints():
    return [int(_) for _ in inp().split()]


if local:
    start=time.time()


t = int(inp())

for _ in range(1,t+1):
    n = int(inp())
    pairs = [0]*n

    for i in range(n):
        pairs[i] = ints()


    problem = pairs[0][1]>pairs[0][0]
    for i in range(1, n):
        prevP, prevC = pairs[i-1]
        curP, curC = pairs[i]

        if prevP<prevC or curP<curC or curP<prevP or curC<prevC or curP-prevP < curC-prevC:
            problem = True
            break
    
    if problem:
        print("NO")
    else:
        print("YES")


if local:
    fin = (time.time()-start)*1000
    print("{:.2f}".format(fin) + "ms")