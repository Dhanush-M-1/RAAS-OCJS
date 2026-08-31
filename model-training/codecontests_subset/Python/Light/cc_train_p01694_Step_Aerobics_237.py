while 1:
    n = int(input())
    if n==0: break
    a = input().split()
    cnt = 0
    for i in range(n//2):
        if a[2*i][0] != a[2*i+1][0]:
            cnt += 1
    print(cnt)
