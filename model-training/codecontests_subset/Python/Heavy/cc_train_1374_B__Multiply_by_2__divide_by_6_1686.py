for _ in range(int(input())):
    n=int(input())
    count=0
    if n==1:
        count=0
        
    else:
        ans=1
        while(n>1):
            #key=0
            if n==2:
                count=-1
                break
            #temp=1
            while(n%6==0):
                #key=0
                n=n//6
                count+=1
                #temp=0 
            if n%3==0:
                n=n*2
                count+=1 
            else:
                break
            # if temp==1:
            #     key+=1
            #     n=n*2
            #     count+=1
            #     if key>1:
            #         ans=-1
            #         break
            # if ans==-1:
            #     break
    if n==1:
        print(count)
    else:
        print(-1)
                