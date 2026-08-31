for _ in range(int(input())):
    n = int(input())
    mat = []
    for i in range(n):
        s = list(map(str,input().split()))
        slist = [j for j in s[0]]
        mat.append(slist)

    #for 0
    a,b,c,d = mat[0][1],mat[1][0],mat[n-2][n-1],mat[n-1][n-2]
    ai,bi,ci,di = [1,2],[2,1],[n-1,n],[n,n-1]
    if a =='1' and b == '1': #11
        if c=='0' and d=='0':
            print(0)
            continue
        elif c=='0' and d=='1':
            print(1)
            print(*di)
        elif c=='1' and d=='0':
            print(1)
            print(*ci)
        else:
            print(2)
            print(*ci)
            print(*di)
    elif a=='0' and b=='0': #00
        if c=='1' and d=='1':
            print(0)
            continue
        elif c=='0' and d=='1':
            print(1)
            print(*ci)
        elif c=='1' and d=='0':
            print(1)
            print(*di)
        else:
            print(2)
            print(*ci)
            print(*di)
    elif a=='0' and b=='1':#01
        if c=='1' and d=='1':
            print(1)
            print(*bi)
            continue
        elif c=='0' and d=='1':
            print(2)
            print(*ai)
            print(*di)
        elif c=='1' and d=='0':
            print(2)
            print(*ai)
            print(*ci)
        else:
            print(1)
            print(*ai)
    else:#10
        if c=='1' and d=='1':
            print(1)
            print(*ai)
            continue
        elif c=='0' and d=='1':
            print(2)
            print(*bi)
            print(*di)
        elif c=='1' and d=='0':
            print(2)
            print(*bi)
            print(*ci)
        else:
            print(1)
            print(*bi)
    
