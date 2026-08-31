# cook your dish here
t = int(input())
for _ in range(t):
    x = input()
    k,n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    ans = [0 for i in range(k)]
    i = j = 0
    flag = 1 
    arr = []
    while i < n and j < m:
        try:
            # print(ans)
            if a[i] <= b[j]:
                arr.append(a[i])
                if a[i] == 0:
                    ans.append(0)
                else:
                    ans[a[i]-1] = a[i]
                i += 1
            else:
                arr.append(b[j])
                if b[j] == 0:
                    ans.append(0)
                else:
                    ans[b[j]-1] = b[j]
                j += 1
        except:
            flag = 0
            break
    while i < n:
        try:
            # print(ans)
            # if a[i] <= b[j]:
                arr.append(a[i])
                if a[i] == 0:
                    ans.append(0)
                else:
                    ans[a[i]-1] = a[i]
                i += 1
        except:
            flag = 0
            break
    while j < m:
        try:
            # print(ans)
            # if a[i] > b[j]:
                arr.append(b[j])
                if b[j] == 0:
                    ans.append(0)
                else:
                    ans[b[j]-1] = b[j]
                j += 1
        except:
            flag = 0
            break
    if flag:
        print(*arr)
    else:
        print(-1)
        
            
            
    
        
        