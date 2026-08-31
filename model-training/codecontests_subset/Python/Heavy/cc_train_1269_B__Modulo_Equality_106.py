n,m=map(int,input().split())
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
from collections import Counter
count1=Counter(arr1)
count2=Counter(arr2)
ans=[]
myset=set()
count=0
def find(count,val):
    ans=[]
    for key in count:
        if count[key]==val:
            ans.append(key)
    return ans
def findx(arr,key,m):
    ans=[]
    for val in arr:
        if key<=val:
            ans.append(val-key)
        else:
            ans.append(val+(m-key))
    return ans
            
for key,val in count1.items():
    tmp=find(count2,val)
    
    lst=findx(tmp,key,m)
    
    if count==0:
        ans=lst
        for val in ans:
            myset.add(val)
    else:
        myset1=set(lst)
        myset=myset.intersection(myset1)
    count+=1
print(sorted(list(myset))[0])