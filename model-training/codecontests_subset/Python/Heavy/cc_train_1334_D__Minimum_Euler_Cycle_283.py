def calcStartIndex(vertex,n):
    i=vertex
    return 1+2*(i-1)*n-i*i+i

def main():
    
    t=int(input())
    allans=[]
    for _ in range(t):
        n,l,r=readIntArr()
        
        startVertex=1
        b=n
        while b>0:
            while startVertex+b<=n and calcStartIndex(startVertex+b,n)<=l:
                startVertex+=b
            b//=2
        
        sv=startVertex
        idx=calcStartIndex(sv,n)
        ans=[]
        adder=1
        addTurn=False
        while idx<=r:
            #sv,sv+1,sv,sv+2,...sv,n. then sv+=1. if sv==n, then put 1 instead of sv
            if addTurn:
                curr=sv+adder
                adder+=1
            else:
                curr=sv
            
            if idx>=l:
                if sv<n:
                    ans.append(curr)
                else:
                    ans.append(1)
            
            addTurn=not addTurn
            idx+=1
            if curr==n:
                sv+=1
                adder=1
                addTurn=False
        
        allans.append(ans)
    multiLineArrayOfArraysPrint(allans)
            
    
    return
    
#import sys
#input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)
import sys
input=lambda: sys.stdin.readline().rstrip("\r\n") #FOR READING STRING/TEXT INPUTS.
 
def oneLineArrayPrint(arr):
    print(' '.join([str(x) for x in arr]))
def multiLineArrayPrint(arr):
    print('\n'.join([str(x) for x in arr]))
def multiLineArrayOfArraysPrint(arr):
    print('\n'.join([' '.join([str(x) for x in y]) for y in arr]))
 
def readIntArr():
    return [int(x) for x in input().split()]
 
inf=float('inf')
MOD=10**9+7
 
main()