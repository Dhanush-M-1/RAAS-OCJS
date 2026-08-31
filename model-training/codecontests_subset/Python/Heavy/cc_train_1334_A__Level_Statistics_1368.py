t = int(input())
while t > 0:
    n = int(input())
    L = []
    for i in range(n):
        L.append(list(map(int, input().split())))
    
    p = True
    for i in range(n-1):
        if L[i+1][0] < L[i][0] or L[i+1][1] < L[i][1]:
            p = False
            break
        if L[i+1][1] - L[i][1] > L[i+1][0] - L[i][0]:
            p = False
            break
        if L[i][0] < L[i][1]: p = False
    if L[n-1][0] < L[n-1][1]: p = False
    if p: print("YES")
    else: print("NO")
    
    t -= 1