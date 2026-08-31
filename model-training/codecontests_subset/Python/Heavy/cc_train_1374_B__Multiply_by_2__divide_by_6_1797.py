for t in range(int(input())):
    #x,y,n=list(map(int,input().split()))
    n=int(input())
    count3=0
    count2=0
    m=n
    if(n==1):
        print(0)
    else:
        if(n%3!=0):
            print(-1)
        else:
            while(m%3==0):
                m=m//3
                count3+=1
            while(m%2==0):
                m=m//2
                count2+=1
            if(count3<count2):
                print(-1)
            elif(count3==count2 and m==1):
                print(count3)
            elif(count3>count2 and m==1):
                print(count3+count3-count2)
            else:
                print(-1)
                
    