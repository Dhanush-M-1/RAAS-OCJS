n=int(input())
li=[]
for i in range(n-1):
    x,y=map(int,input().split())
    li.append([x,y])
parent=[i for i in range(n+1)]
close=[]
bild=[]
def root(t):
    while (parent[t] != t) :
        
        t=parent[t]
    return t
        
def union(s,d):
    p=root(s)
    q=root(d)
    if(p<q):
        parent[q]=p
    else :
        parent[p]=q
def roads():
    for i in li:
        if root(i[0])==root(i[1]):
            close.append([i[0],i[1]])
        else:
            union(i[0],i[1])
    for i in range(2,n+1):
        if root(i)!=root(1):
            union(1,i)
            bild.append([1,i])
roads()
print(len(bild))
for i in range(len(close)):
    print(close[i][0],close[i][1],bild[i][0],bild[i][1])
            
            

    

    
    
        
        
        
    
    