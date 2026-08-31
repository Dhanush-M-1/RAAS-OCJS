for testcases in range(int(input())):
    num=int(input())
    lis=list(map(int,input().split()))
    a=lis[0]
    b=lis[1]
    c=lis[-1]
    if(c>=(a+b)):
        print(1,2,num)
    else:
        print(-1)
        
        
