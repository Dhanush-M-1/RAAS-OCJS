from types import GeneratorType
def bootstrap(f, stack=[]):
    def wrappedfunc(*args, **kwargs):
        if stack:
            return f(*args, **kwargs)
        else:
            to = f(*args, **kwargs)
            while True:
                if type(to) is GeneratorType:
                    stack.append(to)
                    to = next(to)
                else:
                    stack.pop()
                    if not stack:
                        break
                    to = stack[-1].send(to)
            return to
    return wrappedfunc

def generateForStartVertex(startVertex,n):
    if startVertex==n:
        return [1]
    res=[]
    other=startVertex+1
    while other<=n:
        res.append(startVertex)
        res.append(other)
        other+=1
    return res

@bootstrap
def calc(l,r,startVertex,startIndex,n,res):
    
    nextStartIndex=startIndex+2*(n-startVertex)
    if startVertex==n:
        nextStartIndex+=1
    currIdx=startIndex
    if l<nextStartIndex: #run calculation for this startVertex, else skip
        for x in generateForStartVertex(startVertex,n):
            if l<=currIdx<=r:
                res.append(x)
            currIdx+=1
        
    if startVertex+1<=n and r>=nextStartIndex: # need to run next startVertex
        yield calc(l,r,startVertex+1,nextStartIndex,n,res)
        
    yield res
        
        
def main():
    
    t=int(input())
    allans=[]
    for _ in range(t):
        n,l,r=readIntArr()
        res=[]
        calc(l,r,1,1,n,res)
        allans.append(res)
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