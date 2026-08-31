for _ in range(int(input())):
    n = int(input())
    arr = []
    for i in range(n):
        a,b = map(int, input().split())
        arr.append((a,b))
        
    flag = 0
    for loop in range(n):
        if loop == 0:
            if arr[loop][1]>arr[loop][0]: flag=1; break;
        
        else:
            if arr[loop][1]>arr[loop][0]: flag=1; break;
            if arr[loop][0]<arr[loop-1][0]: flag=1; break;
            if arr[loop][1]<arr[loop-1][1]: flag=1; break;
            if arr[loop][1]-arr[loop-1][1]>arr[loop][0]-arr[loop-1][0]: flag=1; break;
            
    if flag==1: print("NO")
    else: print("YES")