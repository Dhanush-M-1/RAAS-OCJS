        
def egcd(a,b):
    if b==0:
        return a,1,0
    d,x,y = egcd(b,a%b)
    return d,y,x-a//b*y
        
def p5():
    n,p,w,d = map(int,input().split())
    g,a,b = egcd(w,d)
    if not p%g == 0:
        print(-1)
    else:
        w = w//g
        d = d//g
        p = p//g
        a = a*p
        b = b*p
        if a < 0:
            if b < 0:
                print(-1)
            else:
                k = b//w
                a = a + k*d
                b = b - k*w
                if a < 0 or a+b>n:
                    print(-1)
                else:
                    print(a,b,n-a-b)
        else:
            if b < 0:
                k = -b//w 
                if not b%w==0:
                    k=k+1
                b = b + k*w
                a = a - k*d
                if a < 0 or a+b>n:
                    print(-1)
                else:
                    print(a,b,n-a-b)
            else:
                k = b//w
                a = a + k*d
                b = b - k*w
                if a < 0 or a+b>n:
                    print(-1)
                else:
                    print(a,b,n-a-b)

def main():
    p5()
    
    
   
if __name__ == '__main__':
    main()