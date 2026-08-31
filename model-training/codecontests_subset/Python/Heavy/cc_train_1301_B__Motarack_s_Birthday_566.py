def check(k, arr, n):
    m = 0
    a = arr.copy()
    for i in range(n):
        if a[i] == -1:
            a[i] = k
            
    for i in range(1, n):
        m = max(m, abs(a[i]-a[i-1]))
        
    return m
    
for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    mn = int(1e9)
    mx = 0
    
    for i in range(n):
        if a[i] == -1:
            if i > 0:
                if a[i-1] != -1:
                    mn = min(mn, a[i-1])
                    mx = max(mx, a[i-1])
            if i < n-1:
                if a[i+1] != -1:
                    mn = min(mn, a[i+1])
                    mx = max(mx, a[i+1])
                    
    print(check((mn+mx)//2, a, n), (mn+mx)//2)