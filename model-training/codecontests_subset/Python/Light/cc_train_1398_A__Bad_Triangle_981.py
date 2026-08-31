for i  in range (int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    k=-1
    for i in range (n):
        if a[i]>=a[0]+a[1]:
            k=i+1
            break
    if k==-1:
        print(k)
    else:
        print('1 2 '+str(k))