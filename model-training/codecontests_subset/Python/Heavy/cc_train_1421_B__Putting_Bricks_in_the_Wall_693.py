t=int(input())
for _ in range(t):
    n=int(input())
    l1=[]
    for i in range(n):
        s=input()
        l1.append(s)
    if l1[0][1]==l1[1][0] and l1[n-2][n-1]==l1[n-1][n-2] and l1[0][1]!=l1[n-2][n-1]:
        print(0)
    elif l1[0][1]==l1[1][0] and l1[n-2][n-1]==l1[n-1][n-2] and l1[0][1]==l1[n-2][n-1]:
        print(2)
        print(1,2)
        print(2,1)
    elif l1[0][1]==l1[1][0] and l1[n-2][n-1]!=l1[n-1][n-2]:
        if l1[n-2][n-1]==l1[0][1]:
            print(1)
            print(n-1,n)
        else:
            print(1)
            print(n,n-1)
    elif l1[0][1]!=l1[1][0] and l1[n-2][n-1]==l1[n-1][n-2]:
        if l1[0][1]==l1[n-1][n-2]:
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    else:
        if l1[0][1]!=l1[n-1][n-2]:
            print(2)
            print(1,2)
            print(n,n-1)
        else:
            print(2)
            print(1,2)
            print(n-1,n)
        