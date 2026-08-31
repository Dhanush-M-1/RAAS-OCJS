t=int(input())
for _ in range(t):
    n=int(input())
    l=[]
    for i in range(n):
        l.append(input())
    if l[0][1]==l[1][0]:
        if l[-2][-1]==l[-1][-2]:
            if l[-2][-1]!=l[0][1]:
                print(0)
            else:
                print(2)
                print(n-1,n)
                print(n,n-1)
        else:
            if l[-2][-1]==l[0][1]:
                print(1)
                print(n-1,n)
            elif l[-1][-2]==l[0][1]:
                print(1)
                print(n,n-1)
    else:
        if l[-2][-1]==l[-1][-2]:
            if l[0][1]==l[-2][-1]:
                print(1)
                print(1,2)
            elif l[1][0]==l[-2][-1]:
                print(1)
                print(2,1)
        else:
            print(2)
            print(1,2)
            if l[-1][-2]==l[1][0]:
                print(n,n-1)
            elif l[-2][-1]==l[1][0]:
                print(n-1,n)
                