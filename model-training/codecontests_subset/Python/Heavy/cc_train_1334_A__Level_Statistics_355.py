
t=int(input())
for _ in range(t):
    n=int(input())
    f=0
    arr=[int(0) for i in range(n)]
    for i in range(n):
        p,c=map(int,input().split())
        arr[i]=[p,c]
    if arr[0][0]>=arr[0][1]:        
        for i in range(1,n):
            if arr[i][1]<arr[i-1][1] or arr[i][0]<arr[i-1][0]:
                f+=1
                print("NO")
                break
            elif arr[i][1]-arr[i-1][1]>arr[i][0]-arr[i-1][0]:
                f+=1
                print("NO")   
                break
        if f==0:
           print("YES")       
    else:
        print("NO")    
                


