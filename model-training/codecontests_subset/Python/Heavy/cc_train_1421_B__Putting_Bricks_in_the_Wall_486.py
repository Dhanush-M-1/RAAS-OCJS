t=int(input())
for _ in range(t):
    n=int(input())
    mt=[]
    for i in range(n):

        s=input()
        mt.append(s)
    a=mt[0][1]
    b=mt[1][0]
    c=mt[-1][-2]
    d=mt[-2][-1]
    

    if c==d=='1':
        if a==b=='0':
            print(0)
        elif a==b=='1':
            print(2)
            print(1,2)
            print(2,1)
        elif a=='0' and b=='1':
            print(1)
            print(2,1)
        else:
            print(1)
            print(1,2)
    elif c==d=='0':
        
        if a==b=='1':
            print(0)
        elif a==b=='0':
            print(2)
            print(1,2)
            print(2,1)
        elif a=='0' and b=='1':
            print(1)
            print(1,2)
        else:
            print(1)
            print(2,1)
    elif c=='0' and d=='1':
        if a=='0' and b=='0':
            print(1)
            print(n,n-1)
        elif a=='0' and b=='1':
            print(2)
            print(2,1)
            print(n,n-1)
        elif a=='1' and b=='0':
            print(2)
            print(1,2)
            print(n,n-1)
        else:
            print(1)
            print(n-1,n)
    else:
        if a=='0' and b=='0':
            print(1)
            print(n-1,n)
        elif a=='0' and b=='1':
            print(2)
            print(1,2)
            print(n,n-1)
        elif a=='1' and b=='0':
            print(2)
            print(2,1)
            print(n,n-1)
        else:
            print(1)
            print(n,n-1)



    
        
    
    
        

    


