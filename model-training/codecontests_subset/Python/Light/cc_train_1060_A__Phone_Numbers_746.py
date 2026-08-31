def pn(l):
    if(l.count('8')==0):
        print(0)
    else:
        a=l.count('8')
        
        p=len(l)//11
        
        if(p==a):
            print(a)
        else:
            if(a>p):
                print(p)
            else:
                print(a)
    return
n=int(input())
l=list(input())
pn(l)