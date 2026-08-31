
for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    i = 2
    while(i < n):
        if(a[i] >= a[0]+a[1]): break

        i += 1
    if i == n: print(-1) 
    else: print(1,2,i+1)
