n,x,y = map(int,input().split())

if (n*y)%100==0:
        if x<((n*y)//100):
                print((n*y)//100 - x)
                
        else:
                print(0)
                
else:
        res = ((n*y)//100)+1
        
        if x<res:
                print(res-x)
        else:
                print(0)