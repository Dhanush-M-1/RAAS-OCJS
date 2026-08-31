n=int(input())
L=[tuple(map(int,input().split())) for k in range(n)]
indI=L[0][0]
if(n<=2):
    print(n)
else:
    ac=2
    for k in range(1,n-1):
        izq=L[k][0]-L[k][1]
        der=L[k][0]+L[k][1]
        if(izq>L[k-1][0] and izq>indI):
            ac+=1
        elif(der<L[k+1][0]):
            ac+=1
            indI=der
    print(ac)
