n=int(input())
d={}
e={}
f={}
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
arr3=list(map(int,input().split()))
for i in arr1:
    d[i]=0
    e[i]=0
for i in arr1:
    d[i]+=1
for i in arr2:
    e[i]+=1
    f[i]=0
for i in e.keys():
    if(d[i]!=e[i]):
        print(i)
        break
for i in arr3:
    f[i]+=1
for i in f.keys():
    if(e[i]!=f[i]):
        print(i)
        break

    
