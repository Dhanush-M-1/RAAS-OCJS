for _ in range(int(input())):
    ans = []
    n = int(input())
    X = []
    for i in range(n):
        X.append(list(input()))
    s1,s2 = int(X[0][1]), int(X[1][0])
    f1,f2 = int(X[n-2][n-1]), int(X[n-1][n-2])
    
    if s1==s2 and f1==f2 and s1!=f1:
        ans = []
    else:
        if s1==s2:
            if f1==s1:
                ans.append([n-1,n])
            if f2==s1:
                ans.append([n,n-1])
        elif f1==f2:
            if f1==s1:
                ans.append([1,2])
            if f1==s2:
                ans.append([2,1])
        else:
            if s1==0:
                ans.append([2,1])
                if f1==0:
                    ans.append([n-1,n])
                if f2==0:
                    ans.append([n,n-1])
            else:
                ans.append([1,2])
                if f1==0:
                    ans.append([n-1,n])
                if f2==0:
                    ans.append([n,n-1])
            
    print(len(ans))
    for i in range(len(ans)):
        print(*ans[i])