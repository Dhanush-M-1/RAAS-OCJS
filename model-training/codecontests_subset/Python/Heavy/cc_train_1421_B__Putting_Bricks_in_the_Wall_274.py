import math
test = int(input())
for t in range(test):
    n = int(input())
    S = []
    for i in range(n):
        s = input()
        S.append(s)
    a = S[0][1];b = S[1][0]
    c = S[n-1][n-2];d = S[n-2][n-1]
    ans = []
    if(a==b):
        if(c==a):
            ans.append([n,n-1])
        if(d==a):
            ans.append([n-1,n])
    else:
        if(c==d):
            if(a==c):
                ans.append([1,2])
            if(b==c):
                ans.append([2,1])
        else:
            if(a==c):
                ans.append([1,2])
                ans.append([n-1,n])
            if(a==d):
                ans.append([1,2])
                ans.append([n,n-1])
    print(len(ans))
    for i in ans:
        print(*i)

        


