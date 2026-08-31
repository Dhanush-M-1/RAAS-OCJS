n=int(input())
l=[]
for i in range(n):
    x,h=map(int,input().split())
    l.append([x,h])
ans=1 
maxx=1 
left=0
if n>1:
    left=l[1][0]-l[0][0]
    for i in range(1,n-1):
        right=l[i+1][0]-l[i][0]
        if l[i][1]<left:
            maxx+=1
            i+=1
            left=l[i][0]-l[i-1][0]
        elif l[i][1]<right:
            maxx+=1
            i+=1 
            left=l[i][0]-l[i-1][0]-l[i-1][1]
        else:
            i+=1 
            left=l[i][0]-l[i-1][0]
    print(maxx+1)        
else:
    print(1)
        
        
        
        
        
    
        