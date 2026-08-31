import sys
def ric(x,a,b):
    global P
    print (x,a,b)
    if P[a] == x:
        return a
    if P[b] == x:
        return b
    if x <P[a] or x>P[b] or a==b:
        return -1
    c = (a+b)//2
    if x == P[c]:
        return c
    if x < P[c]:
        return ric(x,a,c)
    else:
        return ric(x,c,b)


sys.setrecursionlimit(10000)
#sys.stdin = open("input.txt")
T = int(input())
for t in range(T):
    N,M = map(int,input().split())
    w = input()
    P = list(map(int, input().strip().split()))
    P.sort()
    R = [0] * N
    for m in range(M):
        R[P[m]-1] +=1
    a = "abcdefghijklmnopqrstuvwxyz"
    D = {}
    for c in a:
        D[c] = 0
    Passaggi = [0] * N
    for m in range(N-2,-1,-1):
        Passaggi[m] = Passaggi[m+1] + R[m]
        
##        
##    print (w)
##    print(P)
##    print(R)
##    print(Passaggi)
##    
    for x in range(N):
        c = w[x]    
        D[c] +=Passaggi[x]
        
    for c in w:
        D[c] +=1
    for c in a:
        print (D[c], end=" ")
    print()
    
