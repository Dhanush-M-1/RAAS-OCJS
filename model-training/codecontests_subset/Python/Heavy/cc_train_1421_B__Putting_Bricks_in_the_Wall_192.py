t = int(input())
for _ in range(t):
    n = int(input())
    matrix = []
    for i in range(n):
        arr = list(input())
        matrix.append(arr)

    ans = []
    if matrix[0][1]=='1' and matrix[1][0]=='1':
        if matrix[n-1][n-2]=='1':
            ans.append((n-1,n-2))
        if matrix[n-2][n-1]=='1':
            ans.append((n-2,n-1))
    elif matrix[0][1]=='0' and matrix[1][0]=='0':
        if matrix[n-1][n-2]=='0':
            ans.append((n-1,n-2))
        if matrix[n-2][n-1]=='0':
            ans.append((n-2,n-1))
    elif matrix[0][1]!= matrix[1][0]:
        if matrix[n-1][n-2]=='1' and matrix[n-2][n-1]=='1':
            if matrix[0][1]=='1':
                ans.append((0,1))
            else: 
                ans.append((1,0))
        elif matrix[n-1][n-2]=='0' and matrix[n-2][n-1]=='0':
            if matrix[0][1]=='0':
                ans.append((0,1))
            else:
                ans.append((1,0))
        else:
            # Make start 0,0 and end as 1,1
            if matrix[0][1]=='1':
                ans.append((0,1))
            else:
                ans.append((1,0))

            if matrix[n-1][n-2]=='0':
                ans.append((n-1,n-2))
            else:
                ans.append((n-2,n-1))
            
    length = len(ans)
    print(length)
    for i in range(length):
        print(f'{ans[i][0]+1} {ans[i][1]+1}')




    



    