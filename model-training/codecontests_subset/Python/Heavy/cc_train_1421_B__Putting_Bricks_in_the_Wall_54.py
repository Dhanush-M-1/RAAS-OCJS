for ii in range(int(input())):
    n=int(input())
    a,c,ans=[],0,""
    for jj in range(n):
        a.append(input())
    sr,sd,eu,el=a[0][1],a[1][0],a[n-2][n-1],a[n-1][n-2]
    if sr == sd:
        if el == sr:
            c += 1
            ans += str(n) + " " + str(n - 1) + "\n"
        if eu == sr:
            c += 1
            ans += str(n - 1) + " " + str(n) + "\n"
    else:
        if sr == '0' and sd == '1':
            if (eu == '1' and el == '1'):
                c+=1
                ans += str(2) + " " + str(1) + "\n"
            elif (eu == '0' and el == '0'):
                c += 1
                ans += str(1) + " " + str(2) + "\n"
            elif (eu == '0' and el == '1'):
                c += 2
                ans += str(1) + " " + str(2) + "\n"
                ans += str(n) + " " + str(n-1) + "\n"
            else:
                c += 2
                ans += str(1) + " " + str(2) + "\n"
                ans += str(n-1) + " " + str(n) + "\n"
        else:
            if (eu == '1' and el == '1'):
                c += 1
                ans += str(1) + " " + str(2) + "\n"
            elif (eu == '0' and el == '0'):
                c += 1
                ans += str(2) + " " + str(1) + "\n"
            elif (eu == '0' and el == '1'):
                c += 2
                ans += str(1) + " " + str(2) + "\n"
                ans += str(n - 1) + " " + str(n) + "\n"
            else:
                c += 2
                ans += str(1) + " " + str(2) + "\n"
                ans += str(n) + " " + str(n - 1) + "\n"
    print(c)
    print(ans.rstrip())