import math
def L(): return list(map(int,input().split()))
def M(): return map(int,input().split())
def I(): return int(input())
def S(): return input()
def twoD(row): return [L() for i in range(row)]
def fill(val,size): return [val]*size
def strToList(s):return [s[i] for i in range(len(s))]
def printList(a): [print(i,end=" ") for i in a];print()
def binary(a): return bin(a)[2:]
def decimal(s):
    a=0;n=len(s)
    for i in range(n-1,-1,-1):a+=int(s[i])*(2**(n-1-i))
    return a

############################################################################ 
#########################  CODE  BY  ANKIISNAP  ############################
############################################################################

for _ in range(I()):
    s=S()
    k,n,m=M()
    a=L()
    b=L()
    i=0;j=0
    ans=[]
    c=True
    while(i<n or j<m):
        if(i<n and a[i]==0):k+=1;ans.append(a[i]);i+=1
        elif(i<n and a[i]<=k):ans.append(a[i]);i+=1
        elif(j<m and b[j]==0):k+=1;ans.append(b[j]);j+=1
        elif(j<m and b[j]<=k):ans.append(b[j]);j+=1
        else:c=False;break
    if(c):
        for i in ans:
            print(i,end=" ")
        print()
    else:print(-1)
        