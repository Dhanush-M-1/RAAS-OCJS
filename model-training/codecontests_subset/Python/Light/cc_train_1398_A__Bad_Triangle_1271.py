import sys

input = sys.stdin.readline

def inInt():
    return int(input())

def inStr():
    return input().strip("\n")

def inIList():
    return (list(map(int, input().split())))

def inSList():
    return (input().split())

####################################################

def solve(n, l):
    if l[0] + l[1] <= l[n - 1]:
        print("%s %s %s" % (1, 2, n))
    else:
        print(-1)


tests = inInt()
for t in range(tests):
    n = inInt()
    l = inIList()
    solve(n, l)