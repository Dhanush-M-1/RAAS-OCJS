t=int(input())
for _ in range(t):
    n=int(input())
    f,moves=True,0
    if(n==1):
        print("0")
    elif(n%3!=0):
        print("-1")
    else:     
        while(n!=1):
            if(n%6==0):
                n=n/6
                moves=moves+1
            elif(n%3==0):
                n=n*2
                moves=moves+1
            else:
                f=False
                break
        if(f):
            print(moves)
        else:
            print("-1")
            
            
            