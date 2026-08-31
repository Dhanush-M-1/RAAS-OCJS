T = int(input(''))

def prints(l):
    for c in l:
        print(c,end='')
    print('')
al = []
for i in range(65,91,1):
    al.append(chr(i))
for v in range(T):
    a = input('').split(' ')
    s = a[0]
    c = a[1]
    d = {}
    
    for i in range(len(s)-1,-1,-1):
        ch = s[i]
        if(ch not in d): 
            d[ch] = []
        d[ch].append(i)
    res = False
    don = False
    f = 0
    
    s = list(s)
    c = list(c)
    
    ls = len(s)
    lc = len(c)
    
    for i in range(min(ls,lc)):
        d[s[i]].pop()
        if(len(d[s[i]]) == 0):
            del d[s[i]]
        
        if(s[i] < c[i]):
            res = True
            break
        
        if(s[i] == c[i]):
            for a in al:
                if(a < c[i] and a in d):
                    si = d[a].pop()
                    s[si] = s[i]
                    s[i] = a
                    res = True
                    break
                if(a >= c[i]):
                    break
            if(res):
                break
        
        else:
            for a in al:
                if(a < c[i] and a in d):
                    si = d[a].pop()
                    s[si] = s[i]
                    s[i] = a
                    res = True
                    break
                if(a == c[i] and a in d):
                    while(len(d[a]) > 0):
                        si = d[a].pop()
                        if(si>=lc or (si < lc and c[si] > s[i]) or len(d[a]) == 0):
                            s[si] = s[i]
                            s[i] = a
                            res = True
                            don = True
                            break
                    break
                if(a > c[i]):
                    f = 1
                    print('---')
                    break
            break
        
    if(f == 1):
        continue
        
    if(res):
        if(don):
            res = 0
            for h in range(i+1,min(ls,lc),1):
                if(s[h] < c[h]):
                    res = 1
                    break
                if(s[h] == c[h]):
                    continue
                else:
                    res = -1
                    break
            if(res == 1):
                prints(s)
            elif(res == 0):
                if(ls < lc):
                    prints(s)
                else:
                    print('---')
            else:
                print('---')
        
        else:
            prints(s)
        continue
    
    if(i == min(ls,lc)-1):
        if(ls<lc):
            prints(s)
        else:
            print('---')
    else:
        print('---')
        