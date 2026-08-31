k = int(input())
 
for o in range(k):
    n = int(input())
    arr = [int(s) for s in input().split()]
    
    r = []
    for i in range(n):
        if arr[i] == -1:
            if i > 0 and arr[i-1]!=-1:
                r.append(arr[i-1])
            if i < n-1 and arr[i+1]!=-1:
                r.append(arr[i+1])
    
    r.sort()
    
    if len(r) != 0:
        ans = (r[0]+r[-1])//2
    else:
        ans = 0
    
    for i in range(len(arr)):
        if arr[i] == -1:
            arr[i] = ans
    m = abs(arr[0]-arr[1])
    for i in range(n-1):
        u = abs(arr[i]-arr[i+1])
        if m<u:
            m = u
 
 
    print(m, ans)
    