n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]
a.sort()
b.sort()
c.sort()
def Binarysearch(s,key):
    low=0
    high=len(s)-1
    while(high>=low):
        mid=(low+high)//2
        if key<s[mid]:
            high=mid-1
        elif key==s[mid]:
            return mid
        else:
            low=mid+1
    return -1
for i in b:
    a.pop(Binarysearch(a,i))
for j in c:
    b.pop(Binarysearch(b,j))
print(a[0])
print(b[0])