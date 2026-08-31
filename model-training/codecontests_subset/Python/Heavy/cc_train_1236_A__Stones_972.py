t=int(input())
for i in range(t):
    a,b,c=list(map(int,input().split()))
    sum1=0
    if b>0:
        y=c//2
        
        if y<=b:
            sum1+=(c//2)*2 +y
            b-=y
            g=b//2
            if g<=a:
                sum1+=(b//2)*2 + g
            else:
                sum1+=a+a*2
                
        else:
            sum1+=b+b*2
            c-=b*2
            b=0
    print(sum1)
            
        
        
            
    
            
            
            
            
        