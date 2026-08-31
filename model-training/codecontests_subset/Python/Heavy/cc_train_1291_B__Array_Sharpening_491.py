t=int(input())
for k in range(t):
    n=int(input())
    ch=input()
    L=[int(i)for i in ch.split(" ")]
    L2=[]
    for i in range(n):
        if i<n//2:
            if L[i]>=i:
                L2.append(True)
            else:
                L2.append(False)
        else:
            if L[i]>=n-i-1:
                L2.append(True)
            else:
                L2.append(False)
    if n%2==0:
        if L[n//2]>n-(n//2)-1 or L[(n//2)-1]>(n//2)-1:
            L2.append(True)
        else:
            L2.append(False)
    if all(L2):
        print("YES")
    else:
        print("NO")


        
                
    
    
    
        
            
    
    
            
