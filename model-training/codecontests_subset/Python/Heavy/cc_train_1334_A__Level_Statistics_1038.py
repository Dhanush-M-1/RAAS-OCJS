t = int(input())
for i in range(t):
    n = int(input())
    matrix = []
    for j in range(n):
        a = list(map(int,input().split()))
        matrix.append(a)
    prevp = matrix[0][0]
    prevc = matrix[0][1]
    flag =0 
    for j in range(n):
        if(matrix[j][0]<matrix[j][1]):
            flag = 1
            break
        played = matrix[j][0]-prevp
        cleared = matrix[j][1]-prevc
        if(cleared>played):
            flag =1
            break
        if(played<0 or cleared<0):
            flag = 1
            break
        prevp  = matrix[j][0]
        prevc = matrix[j][1]
    if(flag==0):
        print("YES")
    else:
        print("NO")
