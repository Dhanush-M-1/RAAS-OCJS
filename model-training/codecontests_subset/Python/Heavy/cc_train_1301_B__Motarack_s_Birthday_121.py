# import sys
# sys.stdin = open('input.txt', 'r') 
# sys.stdout = open('output.txt', 'w')

for _ in range(int(input())):
    n=int(input())
    L=list(map(int,input().split()))
    R=[]    
    for i in range(n):
        if L[i]==-1:
            if i>0 and L[i-1]!=-1:
                R.append(L[i-1])
            if i<n-1 and L[i+1]!=-1:
                R.append(L[i+1])
    R.sort()
    if len(R)!=0:
        ans=(R[0]+R[-1])//2
    else:
        ans=0
    for i in range(n):
        if L[i]==-1: L[i]=ans
    V=abs(L[0]-L[1])
    for i in range(n-1):
        r=abs(L[i]-L[i+1])
        if V<r: V=r
    print(V,ans)

                



