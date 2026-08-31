# cook your dish here
for _ in range(int(input())):
    n=int(input())
    v=list(map(int,input().split()))
    flag=0
    if len(v)<3:
        print(-1)
        
    else:
        a=v[0]
        b=v[1]
        summ=a+b
        flag=0
        for i in range(2,len(v)):
            if v[i]>=summ:
                print(1,2,i+1,end=' ')
                print()
                flag=1
                break
            
        if flag==0:
            print(-1)
        
    