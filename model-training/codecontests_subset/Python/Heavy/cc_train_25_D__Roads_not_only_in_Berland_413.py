n=int(input())
parent=[i for i in range(n+1)]
size=[1 for _ in range(n+1)]
def paren(x):
    while x!=parent[x]:
        x=parent[x]
    return parent[x]
closingroad=[]
def union(x,y):
    a=paren(x)
    b=paren(y)
    if a!=b:
        if size[a]>size[b]:
            parent[b]=a 
            size[a]+=size[b]
        else:
            parent[a]=b 
            size[b]+=size[a]
            
    else:
        closingroad.append([x,y])

for _ in range(n-1):
    x,y=map(int,input().strip().split(' '))
    union(x,y)
    
count=0
li=set()
for i in range(1,n+1):
    li.add(paren(i))

count=len(li)-1 
li=list(li)
print(count)
for i in range(count):
    print(closingroad[i][0],closingroad[i][1],li[i],li[i+1])
    
    