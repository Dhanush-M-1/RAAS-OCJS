#minimize g, minize s, maximize b

import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)

ans=[]

t=int(input())
for _ in range(t):
    n=int(input())
    p=[int(x) for x in input().split()]
    
    if n<10:
        ans.append('0 0 0')
        continue
    
    midIndex=n//2-1
    breakVal=p[midIndex+1]
    for lastBronze in range(midIndex,-1,-1):
        if p[lastBronze]!=breakVal:
            break
    
    g=0
    gVal=p[0]
    for i in range(n):
        if p[i]!=gVal:
            break
        g+=1
    
    s=g+1
    if g+s-1>=n:
        ans.append('0 0 0')
        continue
    sVal=p[g+s-1]
    for i in range(g+s,n):
        if p[i]!=sVal:
            break
        s+=1
    
    b=lastBronze+1-g-s
    if b<=g:
        ans.append('0 0 0')
        continue
    
    ans.append('{} {} {}'.format(g,s,b))
    
print('\n'.join(ans))