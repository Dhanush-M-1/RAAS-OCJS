




t = int(input())
for _ in range(0,t):
    n = int(input())
    s = []
    for i in range(0,n):
        ss = [k for k in input()]
        s.append(ss)
    ans = []
    kk = [s[0][1],s[1][0],s[-2][-1],s[-1][-2]]
    z,o = kk.count('0'),kk.count('1')
    if z == 0 or o == 0:
        ans.append([1,2])
        ans.append([2,1])
    if z == 1 and o == 3:
        if kk[0] != kk[1]:
            if kk[0] == '1':
                ans.append([1,2])
            else:
                ans.append([2,1])
        else:
            if kk[2] == '1':
                ans.append([n-1,n])
            else:
                ans.append([n,n-1])
    if z == 2 and o == 2 and kk[0] != kk[1]:
        if kk[0] == '0':
            ans.append([1,2])
        if kk[1] == '0':
            ans.append([2,1])
        if kk[2] == '1':
            ans.append([n-1,n])
        if kk[3] == '1':
            ans.append([n,n-1])
    if z == 3 and o == 1:
        if kk[0] != kk[1]:
            if kk[0] == '0':
                ans.append([1,2])
            else:
                ans.append([2,1])
        else:
            if kk[2] == '0':
                ans.append([n-1,n])
            else:
                ans.append([n,n-1])
    print(len(ans))
    for i in ans:
        print(*i)






