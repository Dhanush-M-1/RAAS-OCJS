t=int(input ())
for tt in range (0,t):
    n=int(input ())
    c=0
    s=0
    if(n==1):
        print (0)
    else:
        while(n!=1):
            if(n%6==0):
                n=round(n/6)
                c=0
                s=s+1
            else:
                
                if(n%3==0):
                    c=0
                    n=n*2
                    s=s+1
                elif(n%3!=0):
                    c=1
                    break
        if(c==0):
            print (s)
        elif(c==1):
            print (-1)
