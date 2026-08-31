t = int(input())
for i in range(t):
    n = int(input())
    lst1 = list(map(int,input().split()))
    a = max(lst1)
    b = 0
    for i in range(1,n-1):
        if(lst1[0]+lst1[i] > a):
            continue
        else:
            b = 1
            break
    if(b == 1):
        print(1,end = " ")
        print(i+1,end = " ")
        print(n)
    else:
        print(-1)