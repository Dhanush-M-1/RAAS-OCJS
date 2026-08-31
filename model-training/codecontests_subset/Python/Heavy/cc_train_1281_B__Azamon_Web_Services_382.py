for _ in range(int(input())):
    
    t = input()
    s,c = t.split(" ")
    # print(s,c)
    
    ln = 0
    ln = min(len(s),len(c))
    
    s1 = list()
    for i in s:
        s1.append(i)
        
    c1 = list()
    for i in c:
        c1.append(i)
        
        
        
    ch = -1
    for i in range(ln):
        ch = -1
        ind = -1
        od = ord(c1[i])
        
        for j in range(i,len(s1)):
            if(ord(s1[j])<od):
                ind = j
                ch = i
                # print(ch,ind)
            
        if(ind == -1):
            for j in range(i,len(s1)):
                if(ord(s1[j]) == od):
                    if(j == i):
                        ch = ln+1
                        break
                    else:
                        ch = i
                        ind = j

                
        if(ind>=0):
            # print(ch,ind)
            s1[ch],s1[ind] = s1[ind],s1[ch]
            # print(s1)
            break
        elif(ch == -1):
            break
    
    
    
    s = "".join(s1)
    # print(s,c)
    if(s<c):
        print(s)
    else:
        print("---")