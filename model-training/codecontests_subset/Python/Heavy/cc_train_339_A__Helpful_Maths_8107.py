'''def solve(n,l):
    le=0
    r=len(l)-1
    a=[]
    b=[]
    c=0
    while le<len(l):
        a.append(l[r])
        b.append(l[le])
        r-=1
        le+=1
        c+=1
    for i in range(c):
        print(a[i],b[i])
       
   



n=int(input())
l=list(map(int,input().split()))
solve(n,l)
'''
s=input()
l=len(s)
arr=[]
j=0
for i in range(l):
    if i%2==0:
        arr.append(int(s[i]))
        j+=1
for m in range(1,j):
    for n in range(0,(j-m)):
        if arr[n]>arr[n+1]:
            arr[n],arr[n+1]=arr[n+1],arr[n]
for k in range(j):
    if k==(j-1):
        print(arr[k],end='')
    else:
        s1=str(arr[k])+'+'
        print(s1,end='')
