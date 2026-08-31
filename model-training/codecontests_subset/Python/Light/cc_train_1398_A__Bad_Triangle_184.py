for _ in range(int(input())):
    i,a=int(input()),list(map(int,input().split()))
    [print('1 2 {}'.format(str(i)) if a[0]+a[1]<=a[i-1] else '-1')]