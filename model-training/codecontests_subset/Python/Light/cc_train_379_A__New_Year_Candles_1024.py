import sys
input = sys.stdin.readline
 
############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))#might need to remove the -1
def invr():
    return(map(int,input().split()))
 
h = 0
a, b = invr()
while True:
    if a >= b:
        a -= b-1
        h += b
    else:
        h += a
        break
print(h)