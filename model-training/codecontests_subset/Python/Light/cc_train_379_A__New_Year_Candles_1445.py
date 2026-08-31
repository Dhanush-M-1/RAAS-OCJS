if __name__ == '__main__':
    
    s=input("")
    
    L=s.split()
    
    a=int(L[0])
    b=int(L[1])
    
    tot=0
    
    while( a>=b ):
        c=a%b
        tot=tot+(a-c)
        a= c+ (a-c)//b
    
    
    tot=tot+a
    
    print(tot)
        