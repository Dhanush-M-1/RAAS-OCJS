for _ in range(int(input())):
    n= int(input()) 
    # n,k,z=map(int,input().split())
    a=list(map(int,input().split()))
    s=set(a)
    flag=False
    # dic= {}
    # for k in a:
    #     dic[k]=dic.get(k,0)+1
    
    # for x in dic:
    #     if dic.get(x)>=3:
    #         print(-1)
    #         flag=True
    #         continue    

    # if flag==False:
    #     for i in range(3):
    #         # if a[i-1]==a[i]:
    #         #     pass
    #         # else:
    #         print(i+1,end=" ")
    #     print()
    for i in range(1,n-1):
       
        if a[i-1]+a[i]>a[n-1]:
            pass
        else:
            print(f"{i} {i+1} {n}")  
            flag=True
            break
    

    if flag==False:
        print(-1)      


