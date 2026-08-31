from collections import defaultdict 
def binary(arr,ele):
    start=0
    end=len(arr)-1
    pos=0
    while(start<=end):
        mid=(start+end)//2
        # print(mid)
        if (arr[mid]<ele):
            pos=mid
            start=mid+1
        elif arr[mid]>ele:
            pos=mid
            end=mid-1
        else:
            return mid+1
    if arr[pos]<ele:
        return pos+1
    return pos
        
def result(d,ans,q):
    for i in d.keys():
        arr=d[i]
        # print(arr,q)
        # print(binary(arr,q))
        ans[ord(i)-97]+=binary(arr,q)


# print(binary([1,2,5],3))

for i in range(int(input())):
    n,m=map(int,input().split())
    ans=[0]*26
    s=list(input())
    d=defaultdict(list)
    for i in range(n):
        ans[ord(s[i])-97]+=1
        d[s[i]].append(i)
    # print(d)
    q=list(map(int,input().split()))
    for i in q:
        result(d,ans,i-1)
        # print(ans)
    for i in ans:
        print(i,end=' ')
    print()


