try:
    r1,r2=map(int,input().split())
    c1,c2=map(int,input().split())
    d1,d2=map(int,input().split())
    
    b=(r1-d1+c2)
    if(b%2==0):
        b=b//2
        a=r1-b 
        c=d2-b
        d=c2-b
        if(a>0 and a<10 and b>0 and b<10 and c>0 and c<10 and d<10 and d>0):
            if(a==b or a==c or a==d or b==c or b==d or c==d ):
                print("-1")
                
            else:
                if(a+b==r1 and a+c==c1 and a+d==d1 and b+c==d2 and b+d==c2 and c+d==r2):
                    
                
                    print(a,b)
                    print(c,d)
                else:
                    print("-1")
        else:
            print("-1")
    else:
        print("-1")
        
    
        
except:
    pass
