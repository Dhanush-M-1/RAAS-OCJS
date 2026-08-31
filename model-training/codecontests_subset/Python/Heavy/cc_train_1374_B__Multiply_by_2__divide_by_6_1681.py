# cook your dish here
T=int(input())
for _ in range(T):
    n=int(input())
    count=0
    if(n==1):
        print(0)
    elif(n%3!=0):
        print(-1)
    elif(n%3==0 and n%2!=0):
        while(n!=1):
            if(n%3!=0):
                count=-1
                break
            n=n*2
            n=n//6
            count+=2
        print(count)    
    elif n%3==0 and n%2==0:
        while(n!=1):
            if n%3!=0:
                count=-1
                break
                
            if n%3==0 and n%2!=0:
                n=n*2
                count+=1
            n=n//6
            count+=1
        print(count)        