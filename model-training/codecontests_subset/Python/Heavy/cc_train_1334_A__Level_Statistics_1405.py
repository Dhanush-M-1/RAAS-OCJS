a=int(input())
for i in range(0,a):
    b=int(input())
    plays=[]
    clears=[]
    for i in range(0,b):
        
        arr=list(map(int,input().split()))
        plays.append(arr[0])
        clears.append(arr[1])
    k=0 
    plays.insert(0,0)
    clears.insert(0,0)
    for i in range(0,len(plays)-1):
        if((plays[i+1]-plays[i])<(clears[i+1]-clears[i])):
            k=1 
            break
        if(plays[i+1]<plays[i]):
            k=1 
            break
        if(clears[i+1]<clears[i]):
            k=1 
            break
    if(k==0):
        print("YES")
    else:
        print("NO")
            
        