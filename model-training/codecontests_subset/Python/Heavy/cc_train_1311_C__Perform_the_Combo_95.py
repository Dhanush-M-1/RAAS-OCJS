for _ in range(int(input())):
    h={'a':[],'b':[],'c':[],'d':[],'e':[],'f':[],'g':[],'h':[],'i':[],'j':[],'k':[],'l':[],'m':[],'n':[],'o':[],'p':[],'q':[],'r':[],'s':[],'t':[],'u':[],'v':[],'w':[],'x':[],'y':[],'z':[]}
    n,m=map(int,input().split())
    s=input()
    p=[int(x) for x in input().split()]
    for i in range(len(s)):
        if h[s[i]]!=[]:
            h[s[i]].append(h[s[i]][-1]+1)
        else:
            h[s[i]].append(1)
        for x in h:
            if x !=s[i]:
                if h[x]!=[]:
                    h[x].append(h[x][-1])
                else:
                    h[x].append(0)
    for x in h:
        s=0
        for y in p:
            s+=h[x][y-1]
        print(s+h[x][-1],end=' ')
    print()