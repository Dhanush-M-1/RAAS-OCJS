t = int(input())
while t:
    n = int(input())
    a = list(map(int,input().split(" ")))
    k = n-1
    flag=0
    for i in range(n-2):
        if a[i]+a[i+1] <= a[k]:
            print(f'{i+1} {i+2} {k+1}')
            flag=1
            break
    if flag==0:
        print('-1')
    t-=1