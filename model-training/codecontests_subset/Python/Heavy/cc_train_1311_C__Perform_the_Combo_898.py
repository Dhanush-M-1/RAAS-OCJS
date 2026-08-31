t=int(input())
for i in range(t):
    a=input().split()
    for i in range(len(a)):
        a[i]=int(a[i])
    arr=input()
    p=input().split()
    for i in range(len(p)):
        p[i]=int(p[i])
    final=[0 for i in range(26)]
    arr1=[0 for i in range(len(arr)+1)]
    for i in range(len(p)):
        arr1[p[i]+1]=arr1[p[i]+1]-1
    arr1[0]=len(p)
    for i in range(1,len(arr1)):
        arr1[i]=arr1[i-1]+arr1[i]
    j=0
    for i in range(len(arr)):
        final[ord(arr[j])-97]+=arr1[i+1]
        j+=1
    for i in arr:
        final[ord(i)-97]+=1
    for i in range(26):
        print (final[i],end=" ")
    print()
    