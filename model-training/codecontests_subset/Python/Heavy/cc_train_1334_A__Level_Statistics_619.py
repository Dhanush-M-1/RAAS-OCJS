t = int(input())
ans = []
for i in range(t):
    n = int(input())
    ls = []
    for j in range(n):
        p,c = map(int,input().split(' '))
        ls.append(p)
        ls.append(c)
    k=0
    flag = 0
    if n == 1:
        if ls[k] >= ls[k+1]:
            ans.append("YES")
        else:
            ans.append("NO")
    else:
        while k < len(ls):
            if ls[k+1] > ls[k]:
                ans.append("NO")
                flag =1
                break
            if k>1:
                tmp1 = ls[k] - ls[k-2]
                tmp2 = ls[k+1] - ls[k-1]
                if tmp1 < 0 or tmp2 < 0 or tmp2 > tmp1:
                    ans.append("NO")
                    flag = 1
                    break
            k += 2
        if flag == 0:
            ans.append("YES")
for x in range(t):
    print(ans[x])