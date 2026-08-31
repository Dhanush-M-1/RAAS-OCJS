from sys import stdin, stdout
import math

def expandList(i,n):
    if i!=n:
        out = []
        for j in range(n-i):
            out.append(i)
            out.append(i+j+1)
        return out
    else:
        return [1]

 
T = int(stdin.readline().rstrip())
for iTest in range(T):
    n,l,r = list(map(int,stdin.readline().rstrip().split(' ')))
    
    listSizes = [2*i for i in range(n-1,-1,-1)]
    listSizes[n-1] = 1
    
    found = False
    a = 0
    i=1
    while l>a+listSizes[i-1]:
        a+=listSizes[i-1]
        i+=1
            
    listi = expandList(i,n)
    ind = l-a-1
    startList = listi[ind:]
    
    while r>a+listSizes[i-1]:
        a+=listSizes[i-1]
        i+=1
        startList+=expandList(i,n)
            
    endList = expandList(i+1,n)
    startList += endList
    startList = startList[:r-l+1]
        
    print(' '.join([str(x) for x in startList]))