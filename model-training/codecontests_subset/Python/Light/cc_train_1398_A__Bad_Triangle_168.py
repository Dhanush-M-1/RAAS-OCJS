for _ in range(int(input())):
    n = int(input())
    a = list(map(int,input().split()))
    flag = 0
    min = a[0] + a[1]
    for i in range(2,len(a)):
        if min <= a[i]:
            print(1,2,i+1)
            flag = 1
            break
    if flag == 0:
        print(-1) 