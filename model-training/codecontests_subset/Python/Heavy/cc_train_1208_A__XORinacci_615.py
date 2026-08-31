t=int(input())
for i in range(t):
    a,b,n=map(int,(input()).split())
    n=n%3
    if(n==0):
        print(a)
    elif(n==1):
        print(b)
    else:
        a=bin(a)[2:]
        b=bin(b)[2:]
        sum=0
        for i in range(0,min(len(a),len(b))):
            if(a[len(a)-i-1]!=b[len(b)-i-1]):
                sum=sum+pow(2,i)                
        for i in range(min(len(a),len(b)),max(len(a),len(b))):
            if(len(a)>len(b)):
                if(a[len(a)-1-i]=="1"):
                    sum=sum+pow(2,i)
                    
                continue
            if(b[len(b)-1-i]=="1"):
                sum=sum+pow(2,i)
        print(sum)