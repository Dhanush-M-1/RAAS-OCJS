for tt in range(int(input())):
    n=int(input())
    mat=[]
    for i in range(n):
        mat.append(list(input()))
    c=0;ans=[]
    if mat[0][1]=="1" and mat[1][0]=="1":
        if mat[n-2][n-1]=="1":
            c+=1
            ans.append((n-1,n))
        if mat[n-1][n-2]=="1":
            c+=1
            ans.append((n,n-1))
    elif mat[0][1]=="0" and mat[1][0]=="0":
        if mat[n-2][n-1]=="0":
            c+=1
            ans.append((n-1,n))
        if mat[n-1][n-2]=="0":
            c+=1
            ans.append((n,n-1))
    elif mat[0][1]=="0" and mat[1][0]=="1":
        if mat[n-2][n-1]=="0" and mat[n-1][n-2]=="1":
            c=2
            ans.append((1,2))
            ans.append((n,n-1))
        elif mat[n-2][n-1]=="1" and mat[n-1][n-2]=="0":
            c=2
            ans.append((2,1))
            ans.append((n,n-1))
        elif mat[n-2][n-1]=="1" and mat[n-1][n-2]=="1":
            c=1
            ans.append((2,1))
        elif mat[n-2][n-1]=="0" and mat[n-1][n-2]=="0":
            c=1
            ans.append((1,2))
    elif mat[0][1]=="1" and mat[1][0]=="0":
        if mat[n-2][n-1]=="0" and mat[n-1][n-2]=="1":
            c=2
            ans.append((2,1))
            ans.append((n,n-1))
        elif mat[n-2][n-1]=="1" and mat[n-1][n-2]=="0":
            c=2
            ans.append((1,2))
            ans.append((n,n-1))
        elif mat[n-2][n-1]=="1" and mat[n-1][n-2]=="1":
            c=1
            ans.append((1,2))
        elif mat[n-2][n-1]=="0" and mat[n-1][n-2]=="0":
            c=1
            ans.append((2,1))

    print(c)
    for i in ans:
        print(*i)
    
    
            
        
    
