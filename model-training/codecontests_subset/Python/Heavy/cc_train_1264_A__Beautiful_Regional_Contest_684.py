t = int(input())
for i in range(t):
    n = int(input())
    p = [int(x) for x in input().split()]
    if len(set(p))<4 or n<6:
        print("0 0 0")
    else:
        n = n//2
        cut = p[n]
        p = p[:n]
        p = p[:len(p)-p.count(cut)]

        g = 0
        s = 0
        b = 0
        possible = True
        psize = len(p)

        if len(set(p))>2:
            goldcut = p[0]
            j = 0
            while p[j]==goldcut:
                g+=1
                j+=1
                if j>=psize:
                    possible = False
                    break
                
            while s<=g:
                if j>=psize:
                    possible = False
                    break
                silvercut = p[j]
                while p[j]==silvercut:
                    s+=1
                    j+=1
                    if j>=psize:
                        possible = False
                        break

            b = psize - j
        else:
            possible = False
        
        if b<=g:
            print("0 0 0")
        else:
            print(g, end=" ")
            print(s, end=" ")
            print(b)
        
    
