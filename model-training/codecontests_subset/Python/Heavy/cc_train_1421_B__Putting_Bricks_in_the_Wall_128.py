t=int(input())
for i in range(t):
    n=int(input())
    L=[]
    for i in range(n):
        ch=input()
        L.append(ch)

    I=[]
    if (int(L[0][1])+int(L[1][0]))%2==0:
        if L[n-1][n-2]==L[1][0]:
            I.append((n,n-1))
        if L[n-2][n-1]==L[1][0]:
            I.append((n-1,n))
            
    elif (int(L[n-1][n-2])+int(L[n-2][n-1]))%2==0:
        if L[n-1][n-2]==L[1][0]:
            I.append((2,1))
        if L[n-2][n-1]==L[0][1]:
            I.append((1,2))
    else:
        if L[0][1]=='1':
            I.append((1,2))
        else:
            I.append((2,1))

        if L[n-1][n-2]=='0':
            I.append((n,n-1))
        else:
            I.append((n-1,n))

    print(len(I))
    for i in I:
        print(i[0],i[1])
