for _ in range(int(input())):
    n=int(input())
    a=list(map(int, input().split()))
    def getfl(a):
        c, cc = 1, 0
        fl=[]
        for i in range(1,len(a)):
            if a[i] == a[i-1]: c+=1
            else:
                if cc+c <= n // 2:
                    cc += c
                    fl.append(c)
                else: return [fl, cc]
                c=1
        return [fl, cc]
                
    fl, total = getfl(a)
    if len(fl) < 3:
        print("0 0 0")
        continue
    g = fl[0]
    s=0
    poss = []
    for i in range(1, len(fl)):
        s += fl[i]
        if s > g:
            poss += [[s, total-g-s]]
    found = False
    for el in poss:
        if g < el[0] and g < el[1] and el[1] != 0:
            print(g, el[0], el[1])
            found = True
            break
    if not found:
        print("0 0 0")