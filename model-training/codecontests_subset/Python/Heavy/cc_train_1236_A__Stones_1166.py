no_of_test=int(input())
for f in range(no_of_test):
    n=[int(a) for a in input().split()]
    a=n[0]
    b=n[1]
    c=n[2]
    i=0
    if b>0:
        if b==c or a==b or (a+b>c):
            if c>2*b:
                i+=b
            else:    
                i+=c//2
            b-=i          
            if b>=2*a:
                i+=a
            else:
                i+=b//2
        
        else:
            if c>=2*b:
                i+=b
            else:               
                if b>=c:
                    if b>2*a:
                        i=a
                    else:    
                        i=b//2
                    b-=2*i          
                    if c>=2*b:
                        i+=b
                    else:
                        i+=c//2
                else:
                    if c>2*b:
                        i+=b
                    else:    
                        i+=c//2
                    b-=i          
                    if b>=2*a:
                        i+=a
                    else:
                        i+=b//2

                    
    print(3*i)