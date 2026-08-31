import sys
reader = (line.rstrip() for line in sys.stdin)
input = reader.__next__

def getInts():
    return [int(s) for s in input().split()]

def getInt():
    return int(input())

def getStrs():
    return [s for s in input().split()]

def getStr():
    return input()

def listStr():
    return list(input())

def solve():
    N = getInt()
    A = getInts()
    rooms = set()
    for n in range(N):
        rooms.add((n+A[n])%N)
    if len(rooms) == N:
        return "YES"
    return "NO"
   

T = getInt()
for t in range(T):
    print(solve())
