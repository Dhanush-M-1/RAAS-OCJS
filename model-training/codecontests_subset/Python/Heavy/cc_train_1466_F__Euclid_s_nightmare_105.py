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
    print(' '.join([str(x) for x in arr]))


#######
n,m=[int(x) for x in input().split()]
uf=UnionFind(m+1)
hasOne=[False for _ in range(m+1)] #hasOne[parent]
#a tree cannot have cycles
#a tree can have at most vector with 1 "1"
sPrime=[]
for i in range(n):
    inp=[int(x) for x in input().split()]
    if inp[0]==1:#vector has 1 "1"
        parent=uf.find(inp[1])
        if hasOne[parent]==False:#take this vector
            sPrime.append(i+1)
            hasOne[parent]=True
    else:
        parent1,parent2=uf.find(inp[1]),uf.find(inp[2])
        if parent1!=parent2: #no cycle. will join 2 trees
            if not (hasOne[parent1] and hasOne[parent2]):#take this vector
                sPrime.append(i+1)
                uf.union(inp[1],inp[2])
                newParent=uf.find(inp[1])
                hasOne[newParent]=hasOne[parent1] or hasOne[parent2]
S_magnitude=len(sPrime)
T_magnitude=pow(2,S_magnitude,10**9+7)
print('{} {}'.format(T_magnitude,S_magnitude))
oneLineArrayPrint(sPrime)