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

a,b = map(int,input().split(" "))
r = a
n =a/b
n= int(round(n-0,499999999))
r += n
m= a%b + n
while m>= b:
    n = m/b
    n = int(round(n - 0, 499999999))
    r += n
    m = m %b + n


print(r)
