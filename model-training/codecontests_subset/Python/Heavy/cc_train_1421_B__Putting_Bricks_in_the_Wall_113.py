for _ in range(int(input())):
    n=int(input())
    l=[input() for i in range(n)]
    #print(l)
    if l[0][1]==l[1][0]:
        if l[-1][-2]==l[-2][-1]:
            if l[-1][-2]!=l[1][0]:
                print(0)
            else:
                print(2)
                print(1,2)
                print(2,1)
        else:
            if l[0][1]==l[-1][-2]:
                print(1)
                print(n,n-1)
            else:
                print(1)
                print(n-1,n)
    else:
        if l[-1][-2]==l[-2][-1]:
            if l[0][1]==l[-1][-2]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
        else:
            if l[0][1]==l[-1][-2]:
                print(2)
                print(1,2)
                print(n-1,n)
            else:
                print(2)
                print(1,2)
                print(n,n-1)
            
    