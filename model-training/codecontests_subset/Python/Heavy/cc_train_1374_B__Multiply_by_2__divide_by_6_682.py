t=int(input())
for qw in range(t):
    n=int(input())
    a=b=n
    count2=count3=0
    while(a%2==0):
        a/=2
        count2+=1
    while(b%3==0):
        b/=3
        count3+=1
        a/=3
    if(a!=1 and n!=1):
        print(-1)
    elif(count3<count2):
        print(-1)
    else:
        ans=count3-count2
        n*=(2**(count3-count2))
        #print(n)
        while(n%6==0):
            n/=6
            ans+=1
            if(n!=int(n)):
                break
        #a
        print(ans)