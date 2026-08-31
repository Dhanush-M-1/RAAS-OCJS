for i in range(int(input())):
    n=int(input())
    count=0
    a=1
    x=n
    d={}
    if n==1:
        print("0")
    elif n%3!=0:
        print("-1")
    else:
    
        while(n!=1):
            if ((n/6).is_integer()):
                n=n//6
            else:
                if n not in d:
                    n=n*2
                    d[n]=1
                else:
                    a=0
                    break
            count+=1
        if a==0:
            print("-1")
        else:
            print(count)
        
