for z in range(int(input())):
    n=int(input())
    flag=True
    a=[int(i) for i in input().split()]
    for i in range(n-2):
        if(a[i]+a[i+1]<=a[n-1]):
            flag=False
            print(i+1,i+2,n)
            break
    if flag==True:
        print("-1")