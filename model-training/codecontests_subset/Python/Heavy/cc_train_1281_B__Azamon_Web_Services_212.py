def isASmaller(a,b):
    n=len(a)
    m=len(b)
    for i in range(min(n,m)):
        if a[i]<b[i]: return True
        elif a[i]>b[i]: return False
    if n<m: return True # a is a proper prefix of b
    else: return False

def smallestPossible(a):
    arr=list(a)
    n=len(arr)
    smallestChar='Z'
    smallestIdx=-1
    desirableSwaps=[-1 for _ in range(n)]
    for i in range(n-1,-1,-1):
        if a[i]>smallestChar:
            desirableSwaps[i]=smallestIdx
        if a[i]<smallestChar:
            smallestChar=a[i]
            smallestIdx=i
    for i in range(n):
        if desirableSwaps[i]!=-1: # can swap. swap as early as possible
            temp=arr[i]
            arr[i]=arr[desirableSwaps[i]]
            arr[desirableSwaps[i]]=temp
            break
    return ''.join(arr)

def main():
    
    t=int(input())
    allans=[]
    for _ in range(t):
        a,b=input().split()
        a2=smallestPossible(a)
        if isASmaller(a2,b):
            allans.append(a2)
        else:
            allans.append('---')
    multiLineArrayPrint(allans)
    
    return
    
import sys
# input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)
input=lambda: sys.stdin.readline().rstrip("\r\n") #FOR READING STRING/TEXT INPUTS.

def oneLineArrayPrint(arr):
    print(' '.join([str(x) for x in arr]))
def multiLineArrayPrint(arr):
    print('\n'.join([str(x) for x in arr]))
def multiLineArrayOfArraysPrint(arr):
    print('\n'.join([' '.join([str(x) for x in y]) for y in arr]))
 
def readIntArr():
    return [int(x) for x in input().split()]
# def readFloatArr():
#     return [float(x) for x in input().split()]
 
def makeArr(defaultVal,dimensionArr): # eg. makeArr(0,[n,m])
    dv=defaultVal;da=dimensionArr
    if len(da)==1:return [dv for _ in range(da[0])]
    else:return [makeArr(dv,da[1:]) for _ in range(da[0])]
 
def queryInteractive(x,y):
    print('? {} {}'.format(x,y))
    sys.stdout.flush()
    return int(input())
 
def answerInteractive(ans):
    print('! {}'.format(ans))
    sys.stdout.flush()
 
inf=float('inf')
MOD=10**9+7


for _abc in range(1):
    main()