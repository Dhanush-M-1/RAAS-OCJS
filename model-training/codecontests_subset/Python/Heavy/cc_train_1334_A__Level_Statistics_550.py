t=int(input())
for _ in range(t):
    n=int(input())
    arr = []

    for i in range(n):
        x,y=map(int,input().strip().split())
        arr.append((x,y))
    
    if arr[0][0]>=arr[0][1]:

        flag=True
    
        p,q = arr[0][0],arr[0][1]

        for pair in arr[1:]:
            if pair[0]<pair[1] or pair[0]<p or pair[1]<q or abs(p-q)>abs(pair[0]-pair[1]) :
                flag=False
                break 
            else:
                p=pair[0]
                q=pair[1]
        if flag:
            print("YES")
        else:
            print("NO")
        

            
    else:
        print("NO")

        
        
    
    
    
        
        
    
        