t = int(input())
a=b=c=0
for i in range(t):
    f=0
    n = int(input())
    li = list(map(int,input().split()))[:n]
    # for j in range(n):
    #     for k in range(j+2,n):
    #         if li[j]+li[j+1]<=li[k]:
    #             a=j+1
    #             b=j+1+1
    #             c=k+1
    #             f=1
    #             break
    #     if f==1:
    #         break
    if li[0]+li[1]<=li[len(li)-1]:
        print(1,2,len(li))
    else:
        print(-1)
    # if f==1:
    #     print(a,b,c)
    # else:
    #     print(-1)