t = int(input())


for qwe in range(t):
    
    # n, m = map(int, f.readline().split())
    n, m = map(int, input().split())
    
    # a = list(map(int, f.readline().split()))
    a = list(map(int, input().split()))
    
    # b = list(map(int, f.readline().split()))
    b = list(map(int, input().split()))
    
    flag = False
    
    for i in range(n):
        for j in range(m):
            
            if a[i] == b[j]:
                flag = True
                ans = a[i]
        
        if flag:
            break
    
    if flag:
        print("YES")
        print(1, ans)
    else:
        print("NO")