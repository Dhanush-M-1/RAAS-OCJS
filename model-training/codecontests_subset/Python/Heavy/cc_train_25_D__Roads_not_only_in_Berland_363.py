class SNM:
    def __init__(self, n):
        self.par = [i for i in range(n)]
        self.size = n
        self.sizes = [1 for i in range(n)]
        #self.ans = [i for i in range(n)]
    def find(self, v):
        if self.par[v]==v:
            return v
        ANS = self.find(self.par[v])
        self.par[v]=ANS
        return ANS
    #def get_ans(v):
    #    return ans[find(v)]
    def join(self, v, u):
        pr1=self.find(v)
        pr2=self.find(u)
        if pr1==pr2:
            return 0
        if self.sizes[pr1]>self.sizes[pr2]:
            self.par[pr2]=pr1
        else:
            self.par[pr1]=pr2
        return 1
N=int(input())
L=[]
SN=SNM(N)
for i in range(N - 1):
    A, B=map(int, input().split())
    L.append([A - 1, B - 1])
BadEdges=[]
for i in L:
    if not SN.join(i[0], i[1]):
        BadEdges.append((i[0], i[1]))
print(len(BadEdges))
hk = 0
for i in range(1, N):
    if SN.find(0)!=SN.find(i):
        SN.join(0, i)
        print(BadEdges[hk][0]+1, BadEdges[hk][1]+1, 1, i+1)
        hk+=1
