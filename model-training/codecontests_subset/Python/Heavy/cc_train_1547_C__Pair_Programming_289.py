for t in range(int(input())):
    res = True
    seq = []
    input()
    k, n, m = map(int , input().split())
    lst_n = list(map(int, input().split()))
    lst_m = list(map(int, input().split()))
    for i in range(n+m):
        if len(lst_n) > 0:
            if lst_n[0] > k:
                if len(lst_m) > 0:
                    if lst_m[0] == 0:
                        k+=1
                        seq.append(lst_m[0])
                        lst_m.pop(0)
                    elif lst_m[0] <= k:
                        seq.append(lst_m[0])
                        lst_m.pop(0)
                    else:
                        res = False
                        break
                else:
                    res = False
                    break
            elif lst_n[0] == 0:
                k += 1
                seq.append(lst_n[0])
                lst_n.pop(0)
            elif lst_n[0] <= k:
                seq.append(lst_n[0])
                lst_n.pop(0)

    if len(lst_m) > 0:
        for l in lst_m:
            if l==0:
                k += 1
                seq.append(l)
            elif l <= k:
                seq.append(l)
            else:
                res = False
                break
    
    if res:
        for s in seq:
            print(s,"", end="")
        print()
    else: print(-1)

