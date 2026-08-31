for _ in range (int(input())) :
    n,m = map(int,input().split())
    s=input()
    l=[int(x) for x in input().split()]
    l.sort()
    d = {'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}
    value = m
    index = 0
    for i in range (n) :
        while index < m-1 and i > l[index]-1 :
            index+=1
            value-=1
        d[s[i]]+=value
    for i in range (0,l[m-1]) :
        d[s[i]]+=1
    print(d["a"],end=" ")
    print(d["b"],end=" ")
    print(d["c"],end=" ")
    print(d["d"],end=" ")
    print(d["e"],end=" ")
    print(d["f"],end=" ")
    print(d["g"],end=" ")
    print(d["h"],end=" ")
    print(d["i"],end=" ")
    print(d["j"],end=" ")
    print(d["k"],end=" ")
    print(d["l"],end=" ")
    print(d["m"],end=" ")
    print(d["n"],end=" ")
    print(d["o"],end=" ")
    print(d["p"],end=" ")
    print(d["q"],end=" ")
    print(d["r"],end=" ")
    print(d["s"],end=" ")
    print(d["t"],end=" ")
    print(d["u"],end=" ")
    print(d["v"],end=" ")
    print(d["w"],end=" ")
    print(d["x"],end=" ")
    print(d["y"],end=" ")
    print(d["z"],end=" ")
    print()