try:
    n=int(input())
    s=input()
    l=list(s)
    x=int(n/11)
    if l.count("8")>=x:
        print(x)
    elif l.count("8")==0:
        print("0")
    else:
        print(l.count("8"))
        
        
        
        
except EOFError:
    pass
    