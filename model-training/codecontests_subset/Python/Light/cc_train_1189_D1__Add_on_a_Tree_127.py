import sys
input = sys.stdin.readline

def getN():
    return int(input())
def getList():
    return list(map(int, input().split()))
from sys import exit

n = getN()
vertex = [[] for i in range(n)]

for i in range(n-1):
    a, b = getList()
    vertex[a-1].append(b-1)
    vertex[b - 1].append(a - 1)


for v in vertex:
    if len(v) == 2:
        print("NO")
        exit()


print("YES")