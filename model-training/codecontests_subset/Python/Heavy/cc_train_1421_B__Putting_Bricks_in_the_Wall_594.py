for _ in range(int(input())):
    n = int(input())
    s = [input() for i in range(n)]
    if s[0][1]==s[1][0]:
        if s[-1][-2]==s[-2][-1]:
            if s[-1][-2]==s[0][1]:
                print(2)
                print(1,2)
                print(2,1)
            else:print(0)
        else:
            print(1)
            if s[0][1]==s[n-1][n-2]:print(n,n-1)
            else:print(n-1,n)
    else:
        if s[n - 1][n - 2] == s[n - 2][n - 1]:
            print(1)
            if s[n - 1][n - 2] == s[0][1]:print(1,2)
            else:print(2,1)
        else:
            print(2)
            print(1,2)
            if s[n-1][n-2]==s[1][0]:print(n,n-1)
            else:print(n-1,n)