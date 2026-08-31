def main():
    for _ in range(int(input())):
        n=int(input())
        matx=[]
        for j in range(n):
            matx.append([str(x) for x in input()])

        x=[int(matx[0][1]),int(matx[1][0])]
        y=[int(matx[n-1][n-2]),int(matx[n-2][n-1])]
        if x==[0,0] and y==[1,1 ]:
            print(0)
        elif x==[1,1] and y==[0,0]:
            print(0)
        elif x==[1,1] and y==[1,1]  :
            print(2)
            print(1,2)
            print(2,1)
        elif x==[0,0] and y==[0,0]  :
            print(2)
            print(1,2)
            print(2,1)
        else:
            if x==[1,0]:
                if y==[1,0]:
                    print(2)
                    print(1,2)
                    print(n-1,n)
                elif y==[0,1]:
                    print(2)
                    print(1,2)
                    print(n,n-1)
                elif y==[0,0]:
                    print(1)
                    print(2,1)
                else:
                    print(1)
                    print(1,2)
            if x == [ 0,1]:
                if y == [1, 0]:
                    print(2)
                    print(1, 2)
                    print(n, n-1)
                elif y == [0, 1]:
                    print(2)
                    print(1, 2)
                    print(n - 1, n)
                elif y == [0, 0]:
                    print(1)
                    print(1,2)
                else:
                    print(1)
                    print(2,1)
            if x==[1,1]:
                if y==[1,0]:
                    print(1)
                    print(n,n-1)
                elif y==[0,1]:
                    print(1)
                    print(n-1,n)
            if x==[0,0] :
                if y==[1,0]:
                    print(1)
                    print(n-1,n)
                elif y==[0,1]:
                    print(1)
                    print(n,n-1)

main()