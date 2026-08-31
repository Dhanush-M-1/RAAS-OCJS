def main():
    t = int(input())
    for case in range(t):
        n = int(input())
        A = [int(x) for x in input().split()]
        flag = False
        for i in range(n-2):
            last = n-1
            for rt in range(n-i-2):
                last = n-1 - rt
                if(A[i] + A[i+1] > A[last]):
                    break
                else:
                    print(i+1, i+2, last+1)
                    flag = True
                    break
            if(flag):
                break
        if(not flag):
            print(-1)

        """ flag = False
        for a in range(n):
            for b in range(a+1,n):
                lhs = A[a]+A[b]
                for c in range(b+1,n):
                    if(lhs <= A[c]):
                        print(a+1, b+1, c+1)
                        flag = True
                        break
                if(flag):
                    break
            if(flag):
                break
        if(not flag):
            print(-1) """
if __name__ == '__main__':
    main()