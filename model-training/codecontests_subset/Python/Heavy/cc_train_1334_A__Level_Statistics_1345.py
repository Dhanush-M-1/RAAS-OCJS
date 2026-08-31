from sys import stdin, stdout
import math
 
T = int(stdin.readline().rstrip())
for iTest in range(T):
    n = int(stdin.readline().rstrip())
    
    possible = True
    pLast,cLast = list(map(int,stdin.readline().rstrip().split(' ')))
    if pLast<cLast:
        possible=False
        
    for _ in range(n-1):
        p,c = list(map(int,stdin.readline().rstrip().split(' ')))
        if p-pLast<c-cLast or pLast>p or cLast>c:
            possible = False
        pLast,cLast = p,c
    
    if possible:
        print("YES")
    else:
        print("NO")
