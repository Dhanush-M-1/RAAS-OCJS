from collections import defaultdict
n,k=list(map(int,input().split(' ')))
a=list(map(int,input().split(' ')))

def bact(a,n,k):
    b=sorted(a)
    d=defaultdict(int)
    count=0
    for i in range(n-1):
        if b[i+1]>b[i] and b[i+1]-b[i] <= k:
            d[b[i]]=1
    for i in range(n):
        if d[b[i]]==1:
            count+=1
    # print(d)
    return(n-count)
    # fl=defaultdict(int)
    # for i in range(n):
    #     if fl[a[i]]==1:
    #         count+=1
    #         break
    #     for j in range(n):
    #         if a[j]>a[i] and a[j]<=a[i]+k:
    #             fl[a[i]]=1
    #             count+=1
    #             break
    # return(n-count)

# n=200000
# a=[]
# for i in range(n):
#     a.append(1)
# k=1000000
print(bact(a,n,k))
