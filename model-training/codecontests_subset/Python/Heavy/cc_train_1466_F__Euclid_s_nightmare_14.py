MOD=10**9+7
import sys
input=sys.stdin.buffer.readline #FOR READING PURE INTEGER INPUTS (space separation ok)
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
    def find(self, a): #return parent of a. a and b are in same set if they have same parent
        acopy = a
        while a != self.parent[a]:
            a = self.parent[a]
        while acopy != a: #path compression
            self.parent[acopy], acopy = a, self.parent[acopy]
        return a
    def union(self, a, b): #union a and b
        self.parent[self.find(b)] = self.find(a)

def oneLineArrayPrint(arr):
    print(' '.join([str(x+1) for x in arr]))
def solveActual():
    uf=UnionFind(m+2)
    for i,x in enumerate(vS):
        if len(x)==1:
            x.append(m+1)
        x.append(i) #vS' elements are now [p1,p2,index]
    vS.sort(key=lambda x:x[2])
    sPrime=[]
    for p1,p2,index in vS:
        if uf.find(p1)!=uf.find(p2): #won't form cycle
            uf.union(p1,p2)
            sPrime.append(index)
                
    TSize=pow(2,len(sPrime),MOD)
    print('{} {}'.format(TSize,len(sPrime)))
    oneLineArrayPrint(sPrime)


n,m=[int(x) for x in input().split()]
vS=[] #0-indexed

for _ in range(n):
    xx=[int(x) for x in input().split()]
    #number of 1s, coordinates with 1s
    for i in range(1,len(xx)):
        xx[i]-=1 #0-index
    vS.append(xx[1:])
solveActual()