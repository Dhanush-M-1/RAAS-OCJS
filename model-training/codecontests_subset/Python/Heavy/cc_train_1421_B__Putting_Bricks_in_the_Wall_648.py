for i in range(int(input())):
    n = int(input())
    a = [input() for i in range(n)]
    x, y, w, z = a[0][1], a[1][0], a[-1][-2], a[-2][-1]
    c = 0
    ans=[]
    if (x == '1' and y == '1'):
        if (w == '1'):
            c += 1
            ans.append([n,n-1])
        if z == '1':
            c+=1
            ans.append([n-1,n])
    elif (x == '0' and y == '0'):
        if (w == '0'):
            c += 1
            ans.append([n,n-1])
        if z == '0':
            c+=1
            ans.append([n-1,n])
    else:
        if (w == '1' and z == '1'):
            if (x == '1'):
                c += 1
                ans.append([1,2])
            elif y == '1':
                c+=1
                ans.append([2, 1])
        elif (w == '0' and z == '0'):
            if (x == '0'):
                c += 1
                ans.append([1,2])
            elif y == '0':
                c+=1
                ans.append([2, 1])
        elif (w == '1' and z == '0'):
            c += 1
            ans.append([n-1,n])
            if (x == '1'):
                c += 1
                ans.append([1,2])
            else:
                c+=1
                ans.append([2, 1])
        else:
            c += 1
            ans.append([n-1,n])
            if (x == '0'):
                c += 1
                ans.append([1,2])
            else:
                c+=1
                ans.append([2, 1])
    if (c == 0):
        print(0)
    elif(c==1):
        print(1)
        print(*ans[0])
    else:
        print(2)
        ans.sort()
        print(*ans[0])
        print(*ans[1])