n=int(input())
a=list(map(int,input().split(' ')))
d={}
for i in range(n):
    if a[i] not in d.keys():
        d[a[i]]=1
    else:
        d[a[i]]+=1
e={}
a=list(map(int,input().split(' ')))
for i in range(n-1):
    if a[i] not in e.keys():
        e[a[i]]=1
    else:
        e[a[i]]+=1
f={}
a=list(map(int,input().split(' ')))
for i in range(n-2):
    if a[i] not in f.keys():
        f[a[i]]=1
    else:
        f[a[i]]+=1
for i in d.keys():
    if i in e.keys():
        if d[i]==e[i]:
            pass
        else:
            for j in range(d[i]-e[i]):
                print(i)
    else:
        print(i)
for i in e.keys():
    if i in f.keys():
        if e[i]==f[i]:
            pass
        else:
            for j in range(e[i]-f[i]):
                print(i)
    else:
        print(i)
