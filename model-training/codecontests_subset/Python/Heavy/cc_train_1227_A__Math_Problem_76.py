import sys

input = sys.stdin.readline

def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

t = inp()

for i in range(t):
    n = inp()
    highl = -1
    lowr = 1000000000
    for i in range(n):
        x = inlt()
        highl = max(x[0],highl)
        lowr = min(x[1], lowr)
    if n==1 or highl-lowr<0:
        print(0)
    else:
        print(highl-lowr)
