#rOkY
#FuCk

################################## kOpAl #####################################


t=int(input())

while(t>0):
    
    a=int(input())
    
    l=list(map(int,input().split()))
    
    l.sort()
    
    x=l[0]
    
    y=l[1]
    
    z=max(l)
    
    if(x+y<=z):
        
        print(1,2,a)
        
    else:
        
        print('-1')

       
    t-=1
