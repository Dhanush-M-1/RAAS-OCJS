t = int(input())
for i in range(t):
    n = int(input())
    arr = [int(k) for k in input().split()]
    found = False
    k = 2
    for j in range(n-2):
        while k < n and arr[j] + arr[j+1] > arr[k]:
            k += 1
        if k < n:
            print(j+1, j+2, k+1)
            found = True
            break
    if not found:
        print(-1)
