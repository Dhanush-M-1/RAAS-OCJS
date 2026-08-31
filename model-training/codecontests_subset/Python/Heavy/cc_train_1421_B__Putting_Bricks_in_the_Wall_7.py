for _ in range(int(input())):
    n=int(input())
    arr=[]
    for i in range(n):
        
        temp=list(str(input()))
        arr.append(temp)
    change=[]    
    #print(arr)
    if arr[0][1]==arr[1][0]:
        if arr[0][1]=="1":
            if arr[n-2][n-1]!="0":
                change.append([n-1,n])
            if arr[n-1][n-2]!="0":
                change.append([n,n-1])
        else:
            if arr[n-2][n-1]!="1":
                change.append([n-1,n])
            if arr[n-1][n-2]!="1":
                change.append([n,n-1])
                
    elif arr[n-2][n-1]==arr[n-1][n-2]:
        if arr[n-2][n-1]=="1":
            if arr[0][1]!="0":
                change.append([1,2])
            if arr[1][0]!="0":
                change.append([2,1])
        else:
            if arr[0][1]!="1":
                change.append([1,2])
            if arr[1][0]!="1":
                change.append([2,1])     
    else:
        if arr[0][1]!="0":
            change.append([1,2])
        if arr[1][0]!="0":
            change.append([2,1])   
            
        if arr[n-1][n-2]!="1":
            change.append([n,n-1]) 
        if arr[n-2][n-1]!="1":
            change.append([n-1,n])   
            
    print(len(change))
    for ar in change:
        ar=list(map(str,ar))
        l=" ".join(ar)
        print(l)
            
            
            
            
                
            
                
    
        
   
   