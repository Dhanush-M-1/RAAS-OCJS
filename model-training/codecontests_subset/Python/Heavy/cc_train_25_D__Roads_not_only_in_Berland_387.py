class dsu:
    def __init__(self):
        self.parent=[0]*(10**6)
        self.size=[0]*(10**6)
    def make_set(self,v):
        self.parent[v]=v
        self.size[v]=1
    def union_set(self,a,b):
        a=self.find_set(a)
        b=self.find_set(b)
        if (a!=b):
            if self.size[a]<self.size[b]:
                a,b=b,a
            self.parent[b]=a

            self.size[a]+=self.size[b]
    def find_set(self,v):
        if (v==self.parent[v]):
            return v
        self.parent[v]=self.find_set(self.parent[v])
        return self.parent[v]
n=int(input())
x=dsu()
for i in range(1,n+1):

    x.make_set(i)
p=[]
for i in range(n-1):
    a,b=map(int,input().split())
    if (x.find_set(a)==x.find_set(b)):
        p.append([a,b])

    else:
        x.union_set(a,b)


    #z=[a,b]
tt=set()
for i in range(1,n+1):
    tt.add(x.find_set(i))
tt=list(tt)
print(len(tt)-1)

for i in range(1,len(tt)):

    print(*(p[i-1]+[tt[i],tt[i-1]]))



