n=int(input())
for i in range(n):
    a,b,c=map(int,input().split())
    d=a
    e=b
    f=c
    if(b==0):
        print(0)
        
    else:
        count=0
        while(a>0 and b>1):
            a=a-1
            b=b-2
            count=count+3
        while(b>0 and c>1):
            b=b-1
            c=c-2
            count=count+3
        count1=0  
        while(e>0 and f>1):
            e=e-1
            f=f-2
            count1=count1+3
        while(d>0 and e>1):
            d=d-1
            e=e-2
            count1=count1+3 
        
        print(max(count,count1))    
