for _ in range(int(input())):
    a, b = map(str, input().rstrip().split())
    if a < b:
        print(a)
    else:
        a = list(a)
        mina = sorted(a)
        for i in range(len(mina)):
            if a[i] != mina[i]:
                t = a[i]
                ti =-1
                for j in range(len(a)-1,i,-1):
                    if a[j]==mina[i]:
                        ti=j
                        break
                a[i] = mina[i]
                a[ti] = t
                break
        a = "".join(a)
        if a < b:
            print("".join(a))
        else:
            print("---")
