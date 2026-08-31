for i in range(int(input())):
    n=int(input())
    p=[]
    for i in range(n):
        x=input()
        p.append(x)
        
    if p[0][1]=='1' and p[1][0]=='1':
        if p[-2][-1]=='1' and p[-1][-2]=='1':
            print(2)
            print(n,n-1)
            print(n-1,n)
        elif p[-2][-1]=='1' and p[-1][-2]=='0':
            print(1)
            print(n-1,n)
        
        elif p[-2][-1]=='0' and p[-1][-2]=='1':
            print(1)
            print(n,n-1)
            
        elif p[-2][-1]=='0' and p[-1][-2]=='0': 
            print(0)
            
            
    elif p[0][1]=='0' and p[1][0]=='0':
        if p[-2][-1]=='1' and p[-1][-2]=='1':
            print(0)
            
        elif p[-2][-1]=='1' and p[-1][-2]=='0':
            print(1)
            print(n,n-1)
        
        elif p[-2][-1]=='0' and p[-1][-2]=='1':
            print(1)
            print(n-1,n)
            
        elif p[-2][-1]=='0' and p[-1][-2]=='0': 
            print(2)
            print(n,n-1)
            print(n-1,n)
            
    elif p[0][1]=='0' and p[1][0]=='1':
        if p[-2][-1]=='1' and p[-1][-2]=='1':
            print(1)
            print(2,1)
        elif p[-2][-1]=='1' and p[-1][-2]=='0':
            print(2)
            print(2,1)
            print(n,n-1)
        elif p[-2][-1]=='0' and p[-1][-2]=='1':
            print(2)
            print(2,1)
            print(n-1,n)
        elif p[-2][-1]=='0' and p[-1][-2]=='0':
            print(1)
            print(1,2)
    
            
    
    elif p[0][1]=='1' and p[1][0]=='0':  
        if p[-2][-1]=='1' and p[-1][-2]=='1':
            print(1)
            print(1,2)
        elif p[-2][-1]=='1' and p[-1][-2]=='0':
            print(2)
            print(1,2)
            print(n,n-1)
        elif p[-2][-1]=='0' and p[-1][-2]=='1':
            print(2)
            print(2,1)
            print(n,n-1)
        elif p[-2][-1]=='0' and p[-1][-2]=='0':
            print(1)
            print(2,1)
            
            
            
        
        
            
            
        
            