for _ in range(int(input())):
    n = int(input())
    l = []
    for i in range(n):
        l.append(list(input()))
    
    e = [l[0][1] , l[1][0] , l[n-2][n-1] , l[n-1][n-2]]
    pos = [[1,2] , [2,1] , [n-1,n] , [n,n-1]]
    moves = 0
    ans = []
    
    if(e[0] == e[1]):
        if(e[2] == e[3]):
            if(e[0] == e[2]):
                moves = 2 
                ans.append(pos[2])
                ans.append(pos[3])
            else:
                moves = 0
        else:
            moves = 1 
            if(e[2] == e[0]):
                ans.append(pos[2])
            else:
                ans.append(pos[3])
    else:
        if(e[2] == e[3]):
            moves = 1 
            if(e[0] == e[2]):
                ans.append(pos[0])
            else:
                ans.append(pos[1])
        else:
            moves = 2 
            ans.append(pos[1])
            if(e[2] == e[0]):
                ans.append(pos[2])
            else:
                ans.append(pos[3])
    
    print(moves)
    for i in ans:
        print(*i)