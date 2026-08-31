r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
a=(r1+c1-d2)//2
b=r1-a
c=c1-a
d=c2-b
if a+d==d1 and b+c==d2 and a+b==r1 and c+d==r2 and a+c==c1 and b+d==c2 and len(set([a,b,c,d]))==4 and max(a,b,c,d)<10 and min(a,b,c,d)>0:
    print(a,b)
    print(c,d)
else:
    print(-1)

    
        
        
    
   
        
       
    
         
            
        
