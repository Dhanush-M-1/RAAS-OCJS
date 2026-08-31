l = [int(i) for i in input().split()]
a= l[0];b = l[1]
c= a//b
r = a%b
e=c

def candles(a,b,c,r,e):

    while (c>=1):
        r += c%b
        c //= b 
        e += c
    if r<b:
        return(e)
    elif r==b:
        return (e+1)
    else:
        return(e+candles(a,b,r//b,r%b,r//b))    


if a>=b:
    d = candles(a,b,c,r,e)  
    print(a+d)
else:
    print(a)    
    
    
    
    
    
  
