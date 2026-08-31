for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    b = []
    m = 0
    for i in range(n):
        if(a[i] == -1):
            if(i >0) and (a[i-1] != -1):
                b.append(a[i-1])
            if(i < n-1) and (a[i+1] != -1):
                b.append(a[i+1])
    if(len(b) != 0):
        m = (max(b) + min(b))//2
        
    c = [m if j==-1 else j for j in a]
    k =0
    for t in range(n-1):
        k = max(k, abs(c[t+1] - c[t]))
    print(k, m)    