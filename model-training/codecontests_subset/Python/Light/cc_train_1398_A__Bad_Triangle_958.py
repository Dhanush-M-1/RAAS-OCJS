def solve(n, a):
    ind1, ind2, ind3 = 0, 0, 0    
    for i in range(n-1):
        k = i + 1
        found = False
        for j in range(ind2+1, n):
            if a[i] + a[j] <= a[k] or a[j] + a[k] <= a[i] or a[k] + a[i] <= a[j]:
                found = True
                ind1, ind2, ind3 = i, k, j
                break
        if found:
            print(ind1+1, ind2+1, ind3+1)
            break
        else:
            print(-1)
            break
                

t = int(input())
while t:
    n = int(input())
    a = [int(i) for i in input().split()]
    solve(n, a)
    t -= 1
