def main():
    for _ in range(int(input())):
        n=int(input())
        l=[list(map(lambda x: int(x) if(not (x=='S' or x=='F')) else x,input())) for i in range(n)]
        if(l[0][1]==l[1][0] and l[n-1][n-2]==l[n-2][n-1] and l[n-1][n-2]==1-l[1][0]):
            print(0)
        elif(l[0][1]==l[1][0] and l[n-1][n-2]==l[n-2][n-1]):
            print(2)
            print(1,2)
            print(2,1)
        elif(l[0][1]!=l[1][0] and l[n-1][n-2]==l[n-2][n-1]):
            print(1)
            print(*([1,2] if(l[0][1]==l[n-1][n-2]) else [2,1]))
        elif(l[0][1]==l[1][0] and l[n-1][n-2]!=l[n-2][n-1]):
            print(1)
            print(*([n,n-1] if(l[0][1]==l[n-1][n-2]) else [n-1,n]))
        else:
            print(2)
            print(*([1,2] if(l[0][1]==0) else [2,1]))
            print(*([n,n-1] if(l[n-1][n-2]==1) else [n-1,n]))
main()