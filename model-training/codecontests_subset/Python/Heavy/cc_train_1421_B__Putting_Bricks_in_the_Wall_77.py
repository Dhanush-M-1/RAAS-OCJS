for _ in range(int(input())):
    ls =[]
    n = int(input())
    for i in range(n):
        ls.append(input())
    a = ls[0][1];    b = ls[1][0];    c = ls[n-2][n-1];    d= ls[n-1][n-2]
    ans =[]
    f=1
    if a==b :
        if a==c:
            ans.append([n-1 , n])
        if a==d:
            ans.append([n, n-1])
        print(len(ans))
        for i in ans:
            print(*i)
    elif c==d:
        if a==c:
            ans.append([1, 2])
        if c==b:
            ans.append([2 , 1])
        print(len(ans))
        for i in ans:
            print(*i)
    else:
        if a==c and b==d:
            print(2)
            print(1, 2)
            print(n , n- 1)
        else:
            print(2)
            print(2, 1)
            print(n , n-1)
