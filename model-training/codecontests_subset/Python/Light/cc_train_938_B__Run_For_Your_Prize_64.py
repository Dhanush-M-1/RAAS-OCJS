import sys
lines = sys.stdin.read().splitlines()
lincnt = -1 

def input():
    global lincnt
    lincnt += 1
    return lines[lincnt]


input()
l = map(int, input().split())
print(max(min(x - 1, 1000000 - x) for x in l))
