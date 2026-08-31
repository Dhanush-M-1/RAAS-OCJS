t = int(input())
for i in range(t):
    n = int(input())
    a = [int(s) for s in input().split()]
    sum = a[0] + a[1]
    flag = 0
    j = 2
    while(flag == 0):
        if(sum <= a[j]):
            print(1, 2, j+1)
            flag = 1
        if(j == n-1 and flag == 0):
            print(-1)
            flag = 1
        j += 1