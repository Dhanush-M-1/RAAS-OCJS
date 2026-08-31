t=int(input())
while(t>0):
    n=int(input())
    a=input()
    c=0;k=0
    if(a[0]=='>'):
        print(0)
    elif(a[n-1]=='<'):
        print(0)
    elif(n==1):
        print(0)
    else:
        for i in a:
            if(i=='<'):
                c+=1
            else:
                break
        for i in range(n-1,-1,-1):
            if(a[i]=='>'):
                k+=1
            else:
                break
        if(c>k):
            print(k)
        else:
            print(c)
    t-=1