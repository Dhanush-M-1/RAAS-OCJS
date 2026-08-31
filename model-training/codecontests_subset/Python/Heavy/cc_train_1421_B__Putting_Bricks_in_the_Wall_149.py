from sys import *
input = stdin.readline

for _ in range(int(input())):
    
    n = int(input())
    
    matrix = []
    for i in range(n):
        a = []
        s = input()
        for em in s[:-1]:
            if(em == 'S' or em == 'F'):
                a.append(em)
            else:
                a.append(int(em))
        matrix.append(a)
        
    ans = []
    
    if(matrix[0][1] == matrix[1][0]):
        if(matrix[n-1][n-2] == matrix[0][1]):
            ans.append((n,n-1))
        if(matrix[n-2][n-1] == matrix[0][1]):
            ans.append((n-1,n))
    elif(matrix[n-1][n-2] == matrix[n-2][n-1]):
        if(matrix[n-1][n-2] == matrix[0][1]):
            ans.append((1,2))
        if(matrix[n-2][n-1] == matrix[1][0]):
            ans.append((2,1))
    else:
        sn = matrix[n-1][n-2] + matrix[n-2][n-1] + matrix[1][0] + matrix[0][1]
        flag = -1
        if(sn <= 2):
            flag = 1
        else:
            flag = 0
        if(matrix[0][1] != flag and matrix[1][0] != flag):
            if(matrix[n-1][n-2] == flag):
                ans.append((n,n-1))
            if(matrix[n-2][n-1] == flag):
                ans.append((n-1,n))
        elif(matrix[n-1][n-2] != flag and matrix[n-2][n-1] != flag):
            if(matrix[0][1] == flag):
                ans.append((1,2))
            if(matrix[1][0] == flag):
                ans.append((2,1))
        else:
            if(matrix[n-1][n-2] == flag):
                matrix[n-1][n-2] = 1-flag
                ans.append((n,n-1))
            if(matrix[n-2][n-1] == flag):
                matrix[n-2][n-1] = 1-flag
                ans.append((n-1,n))
            if(matrix[0][1] != flag):
                matrix[0][1] = flag
                ans.append((1,2))
            if(matrix[1][0] != flag):
                matrix[1][0] = flag
                ans.append((2,1))
        
    stdout.write(str(len(ans))+'\n')
    for x,y in ans:
        stdout.write(str(x)+' '+str(y)+'\n')

        