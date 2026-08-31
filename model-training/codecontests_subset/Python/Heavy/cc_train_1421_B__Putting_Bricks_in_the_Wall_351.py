

for _ in range(int(input())):
    n = int(input())
    s = []
    for __ in range(n):
        s.append([int(x) for x in input() if x.isdigit()])
    s[0].insert(0,0)
    s[n-1].insert(n-1,0)

    c = 0
    ans = []
    
    if s[0][1] and s[1][0]:
        if s[n-1][n-2]:
            c += 1
            ans.append([n,n-1])
        if s[n-2][n-1]:
            c += 1
            ans.append([n-1,n])
        print(c)
        for i in ans:
            print(*i)
        continue
    elif not(s[0][1] or s[1][0]):
        if not s[n-1][n-2]:
            c += 1
            ans.append([n,n-1])
        if not s[n-2][n-1]:
            c += 1
            ans.append([n-1,n])
        print(c)
        for i in ans:
            print(*i)
        continue
    elif s[n-1][n-2] and s[n-2][n-1]:
        if s[0][1]:
            c += 1
            ans.append([1,2])
        if s[1][0]:
            c += 1
            ans.append([2,1])
        print(c)
        for i in ans:
            print(*i)
        continue
    elif not(s[n-1][n-2] or s[n-2][n-1]):
        if not s[0][1]:
            c += 1
            ans.append([1,2])
        if not s[1][0]:
            c += 1
            ans.append([2,1])
        print(c)
        for i in ans:
            print(*i)
        continue
    else:
    #elif s[0][1] or s[1][0]:
        if s[n-1][n-2] or s[n-2][n-1]:
            if s[n-1][n-2]:
                if s[0][1]:
                    print(2)
                    print(1, 2)
                    print(n-1, n)
                    continue
                else:
                    print(2)
                    print(2, 1)
                    print(n-1, n)
                    continue
            else:
                if s[0][1]:
                    print(2)
                    print(1, 2)
                    print(n, n-1)
                    continue
                else:
                    print(2)
                    print(2, 1)
                    print(n, n-1)
                    continue
        else:
            if not s[0][1]:
                print(1)
                print(0, 1)
                continue
            else:
                print(1)
                print(1, 1)
                continue