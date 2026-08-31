for _ in range (int(input())) :
    dic = {'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'u':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}
    n,m = map(int,input().split())
    s = input() 
    l = [int(x) for x in input().split()]
    l.sort()
    j = 0 
    for i in range (len(l)) :
        while j < l[i] :
            dic[s[j]] += m+ 1 
            j += 1 
        m -= 1 
    while j < n :
        dic[s[j]] += m+ 1 
        j += 1 
    
    l = sorted(dic.items(),key = lambda x:x[0])
    for i in l :
        print(i[1],end=" ")
    print()