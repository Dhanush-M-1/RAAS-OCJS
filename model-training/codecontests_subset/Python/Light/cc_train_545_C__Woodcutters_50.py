l=[]
n=int(input())
for i in range(n):
    a,b=map(int,input().split())
    l.append((a,b))
count=min(n,2)
left=1
for i in range(1,n-1):
    if left:
        if l[i][0]-l[i-1][0]>l[i][1]:
            count+=1
        elif l[i+1][0]-l[i][0]>l[i][1]:
            count+=1
            left=0
            l[i]=(l[i][0]+l[i][1],l[i][1])
    else:
        if l[i][0]-l[i-1][0]>l[i][1]:
            count+=1
            left=1
        elif l[i+1][0]-l[i][0]>l[i][1]:
            count+=1
            l[i]=(l[i][0]+l[i][1],l[i][1])
    #print(left,l[i][0],count)
print(count)
            
    
    
    
