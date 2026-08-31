import math
for _ in range(int(input())):
    n=int(input())
    if n==1:
        print(0)
    elif n%3!=0:
        print(-1)
    else:
        
        x=n
        r=0
        while n%math.pow(3,r)==0:
            r+=1
        r-=1
        x=n//math.pow(3,r)
        s=0
        while n%math.pow(2,s)==0:
            s+=1
        s-=1
        
        three=r
        two=s
        if int(math.pow(2,two)*math.pow(3,three))==n:
            x=three
            y=three-two
            if x>=0 and y>=0 :
                print(x+y)
            else:
                print(-1)
        else:
            print(-1)
            
        
    
    