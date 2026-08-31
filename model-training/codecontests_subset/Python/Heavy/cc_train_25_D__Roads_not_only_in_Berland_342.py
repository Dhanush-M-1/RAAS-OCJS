class Graph:
    def __init__(self,n):
        self.rank=[1]*(n+1)
        self.parent=[0]+[i for i in range(1,n+1)]
    
    def find(self,a):
        if self.parent[a]==a:
            return a
        if self.parent[a]!=a:
            self.parent[a]=self.find(self.parent[a])
        return self.parent[a]
 
    def union(self,a,b):
        pa=self.find(a)
        pb=self.find(b)
        if pa!=pb:
            if self.rank[pa]>self.rank[pb]:
                self.parent[pb]=pa
            elif self.rank[pa]<self.rank[pb]:
                self.parent[pa]=pb
            else:
                self.parent[pb]=pa
                self.rank[pa]+=1
            return 1
        else:
            delete.append([a,b])
        return 0
n=int(input())
graph=Graph(n)
c=n
delete=[]
for _ in range(n-1):
    a,b=map(int,input().split())
    c-=graph.union(a,b)
arr=[]
print(c-1)
for i in range(1,n+1):
    arr.append(graph.find(i))
arr=list(set(arr))
for i in range(1,len(arr)):
    print(delete[i-1][0],delete[i-1][1],arr[0],arr[i])