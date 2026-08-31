from operator import itemgetter, attrgetter, methodcaller
n=int(input())
s=input()
f=True
i=0
start=dict()
end=dict() 
for i in range(n):
    e=s[i]
    if e not in start:
        start[e]=i
    end[e]=i
i=0
while (i< len(end.keys()))and f:
    x=end[sorted(end.keys())[i]] 
    j=i+1
    while (j<len(start.keys()))and f:
        y=start[sorted(start.keys())[j]]
        if x>y:
            print("YES")
            print(y+1,x+1)
            f=False
        j+=1    
    i+=1    
  
if f:
    print("NO")
