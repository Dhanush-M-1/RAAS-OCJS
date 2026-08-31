import sys

def mcd(a,b):
    if a<b:
        a,b = b,a
    c = b
    while b > 0:
        r = a % b
        a = b
        c = b
        b = r
    return c
def mcm(a,b):
    return a*b//mcd(a,b)

#sys.stdin= open("input.txt")
N = int(input())
A = list(map(int,input().split()))
z = A[0]
x = A[0]
M = max(A)
B=[]
z = 0
for n in range(0,N):
    if A[n] != M:
        b = M-A[n]
        B.append(b)
        if z == 0:
            z = b
        z = mcd(z,b)
        #x = mcm(x,A[n])
y = 0
#print (B)
if N == 2:
    print (1,max(A)-min(A))
else:     
    for a in A:
        y = y + (M-a) // z
    print (y, z)
