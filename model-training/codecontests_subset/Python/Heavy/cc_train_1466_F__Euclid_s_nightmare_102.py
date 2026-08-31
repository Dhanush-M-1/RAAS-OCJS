from collections import defaultdict
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

def canTake(newEdgesCnt,newVerticesCnt,newHasOne):
    if newHasOne:return newEdgesCnt<=newVerticesCnt
    else: return newEdgesCnt<=newVerticesCnt-1

def handleOne(i,v1,sPrime,cEc,cVc,cHO,vV,uf):
    parent=uf.find(v1)
    oldEdgesCnt=cEc[parent]
    oldVerticesCnt=cVc[parent]
    
    newEdgesCnt=oldEdgesCnt+1
    if vV[v1]==False:newVerticesCnt=oldVerticesCnt+1
    else:newVerticesCnt=oldVerticesCnt
    
#    print('i:{} oldE:{} oldV:{} newE:{} newV:{}'.format(i,oldEdgesCnt,oldVerticesCnt,newEdgesCnt,newVerticesCnt))
    
    if canTake(newEdgesCnt,newVerticesCnt,True):
        sPrime.append(i)
        vV[v1]=True
        cEc[parent]=newEdgesCnt
        cVc[parent]=newVerticesCnt
        cHO[parent]=True
    
    return

def handleTwo(i,v1,v2,sPrime,cEc,cVc,cHO,vV,uf):
    parent1=uf.find(v1)
    parent2=uf.find(v2)
    if parent1!=parent2:
        oldEdgesCnt=cEc[parent1]+cEc[parent2]
        oldVerticesCnt=cVc[parent1]+cVc[parent2]
    else:
        oldEdgesCnt=cEc[parent1]
        oldVerticesCnt=cVc[parent1]
    
    newEdgesCnt=oldEdgesCnt+1
    newVerticesCnt=oldVerticesCnt
    if vV[v1]==False:newVerticesCnt+=1
    if vV[v2]==False:newVerticesCnt+=1
    if canTake(newEdgesCnt,newVerticesCnt,cHO[parent1] or cHO[parent2]):
        sPrime.append(i)
        vV[v1]=True
        vV[v2]=True
        uf.union(v1,v2)
        newParent=uf.find(v1)
        cEc[newParent]=newEdgesCnt
        cVc[newParent]=newVerticesCnt
        cHO[newParent]=cHO[parent1] or cHO[parent2]
    
    return
    
def solveActual():
    uf=UnionFind(m)
    
    #each component has k vertices.
    #each component shall have at most k-1 useful edges if componentHasOne==False, or k edges if it's True
    #pick the k-1 or k edges with the smallest values
    #each component contributes independently 2**(nEdges) to the number of ways.
    #just find 2**(nEdges or number of included indexes)
    
    sPrime=[]
    cEc=[0 for _ in range(m)] #cEc[parent]=component edge counts
    cVc=[0 for _ in range(m)] #cVc[parent]=component vertex count
    cHO=[False for _ in range(m)] #countHasOne cHO[parent]=True if this component has an edge with only 1 vertex
    vV=[False for _ in range(m)] #True if the vertex has been visited
    for i,x in enumerate(vS): #idx,vertex(vertices)
        nVertices=len(x)
        if nVertices==1:
            handleOne(i,x[0],sPrime,cEc,cVc,cHO,vV,uf)
        else:
            handleTwo(i,x[0],x[1],sPrime,cEc,cVc,cHO,vV,uf)
    
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