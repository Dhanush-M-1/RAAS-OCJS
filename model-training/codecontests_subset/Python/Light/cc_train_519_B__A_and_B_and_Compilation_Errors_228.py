def A():
    x=int(input())
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    c=list(map(int,input().split()))

    a.sort()
    b.sort()
    c.sort()
    for i in range(x):
        if i==x-1: 
            print(a[i])
            break
        if a[i]!=b[i]: 
            print(a[i])
            break
    for j in range(x-1): 
        if j==(x-2):
            print(b[j])
            break
        else:
            if b[j]!=c[j]: 
                print(b[j])
                break

A()