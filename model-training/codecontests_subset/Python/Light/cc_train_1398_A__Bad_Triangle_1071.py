for i in range(int(input())):
    n=int(input())
    chk=[int(i) for i in input().split()]
    if(chk[0]+chk[1]>chk[-1]):
        print(-1)
    else:
        print(1,2,n)