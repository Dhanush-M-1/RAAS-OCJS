# cook your dish here
n=int(input())
for h in range(0,n):
    a,b,c=map(int,input().split(" "))
    
    if a<=c and c<=b:
        u=(b-(b%c))+c
        print(u)
    else:
        print(c)
        
    
    
    
    
    

        