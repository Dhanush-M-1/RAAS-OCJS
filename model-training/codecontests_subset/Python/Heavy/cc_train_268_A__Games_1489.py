import sys
input = sys.stdin.readline

############ ---- Input Functions ---- ############
def inp():
    return(int(input()))
def inlt():
    return(list(map(int,input().split())))
def insr():
    s = input()
    return(list(s[:len(s) - 1]))
def invr():
    return(map(int,input().split()))

n =inp()

h = []
a = []
for i in range(n):
    x, y = invr()
    h.append(x)
    a.append(y)
count = 0
for i in range(n):
    for j in range(n):
        if h[i] == a[j]:
            count = count + 1
print(count)