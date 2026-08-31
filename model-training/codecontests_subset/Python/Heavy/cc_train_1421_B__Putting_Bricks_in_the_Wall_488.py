for t in range(int(input())):
    s = []
    n = int(input())
    for i in range(n):
        s.append(input())
    n = n-1
    seti = {s[0][1],s[1][0],s[n][n-1],s[n-1][n]}
    if seti=={'1'} or seti =={'0'}:
        print(2)
        print("1 2")
        print("2 1")
    elif s[0][1] == s[1][0] and s[n][n-1]==s[n-1][n]:
        print(0)
    elif s[0][1] == s[n][n-1] and s[1][0]==s[n-1][n]:
        print(2)
        print("1 2")
        print("%i %i"%(n,n+1))
    elif s[0][1] == s[n-1][n] and s[1][0] == s[n][n-1]:
        print(2)
        print("1 2")
        print("%i %i"%(n+1,n))
    elif s[0][1] != s[1][0]:
        print(1)
        if s[0][1] == s[n][n-1]:
            print("1 2")
        else:
            print("2 1")
    elif s[n][n-1]!=s[n-1][n]:
        print(1)
        if s[0][1] == s[n][n-1]:
            print("%i %i"%(n+1,n))
        else:
            print("%i %i"%(n,n+1))


