for y in range(int(input())):
    n=int(input())
    lst=list(map(int,input().split()))
    a=0
    b=1
    c=n
    if lst[a]+lst[b]>lst[n-1]:
        print('-1')
    else:
        print('1','2',str(n))