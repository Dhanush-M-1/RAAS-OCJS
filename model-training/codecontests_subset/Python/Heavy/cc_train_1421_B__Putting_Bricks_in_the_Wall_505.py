t=int(input())
for _ in range(t):
    n=int(input())
    mat=[input() for _ in range(n)]
    
    ans=[]
    #if both the adjacent cell are same(of S)
    if(mat[0][1]==mat[1][0]):
        if(mat[n-2][n-1]==mat[0][1]):
            #print(n-2,n-1)
            ans.append([n-2+1,n-1+1])
        if(mat[n-1][n-2]==mat[0][1]):
            #print(n-1,n-2)
            ans.append([n-1+1,n-2+1])
    


    #if both the adjacent cells are different(of S)
    else:
        #(if both the adjacent cells of E are same)

        if(mat[n-2][n-1]==mat[n-1][n-2]):
            if(mat[n-2][n-1]==mat[0][1]):
                ans.append([1,2])
            else:
                ans.append([2,1])
        #if both the adjacent cells are different(0f E)
        else:
            if(mat[n-2][n-1]==mat[0][1]):
                ans.append([1,2])
                ans.append([n-1+1,n-2+1])

            elif(mat[n-1][n-2]==mat[0][1]):
                ans.append([1,2])
                ans.append([n-2+1,n-1+1])
            elif(mat[n-2][n-1]==mat[1][0]):
                ans.append([2,1])
                ans.append([n-1+1,n-2+1])
            elif(mat[n-1][n-2]==mat[1][0]):
                ans.append([2,1])
                ans.append([n-2+1,n-1+1])
    print(len(ans))
    for i in ans:
        print(i[0],i[1])