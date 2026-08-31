def main():
    for i in range(int(input())):
        n = int(input())
        matx = []
        for i in range(n):
            x = list(input())
            matx.append(x)
        x = matx[n-2][n-1]
        y = matx[n-1][n-2]
        a = matx[0][1]
        b = matx[1][0]
        v=a+b+x+y
        if v=='0100' or v=='1011':
            print(1)
            print(1,2)
        elif v=='0011' or v=='1100':
            print(0)
        elif v=='0111' or v=='1000':
            print(1)
            print(2,1)
        elif v == '0110' or v == '1001':
            print(2)
            print(2, 1)
            print(n,n-1)
        elif v == '0000' or v == '1111':
            print(2)
            print(1,2)
            print(2, 1)
        elif v == '0101' or v == '1010':
            print(2)
            print(2, 1)
            print(n-1,n)
        elif v == '1110' or v == '0001':
            print(1)
            print(n-1, n)
        elif v == '0010' or v == '1101':
            print(1)
            print(n, n-1)


if __name__ == "__main__":
    main()
