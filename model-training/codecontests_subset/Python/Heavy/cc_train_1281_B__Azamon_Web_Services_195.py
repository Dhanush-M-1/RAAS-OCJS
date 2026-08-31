for i in range(int(input())):
    a,b = map(list,input().split())
    ind = -1
    for i in range(len(a)):
        if a[i] != 'A':
            m = a[i]
            flag = False
            ind = i
            for g in range(i+1, len(a)):
                if flag:
                    if a[g] <= m:
                        m = a[g]
                        ind = g
                else:
                    if a[g] < m:
                        flag = True
                        m = a[g]
                        ind = g
            if flag:
                a[i],a[ind] = a[ind],a[i]
                break
    a = "".join(a)
    b = "".join(b)
    if a < b:
        print(a)
    else:


        print('---')
