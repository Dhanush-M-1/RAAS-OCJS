n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
di1 = {x:0 for i,x in enumerate(a)}
di2 = {x:0 for i,x in enumerate(a)}
di3 = {x:0 for i,x in enumerate(a)}
for i in range(n-2):
    di1[a[i]]+=1
    di2[b[i]]+=1
    di3[c[i]]+=1
di1[a[n-1]]+=1
di1[a[n-2]]+=1
di2[b[n-2]]+=1
for i,x in enumerate(di2):
    if di2[x]!=di1[x]:
        print(x)
        break
for i,x in enumerate(di3):
    if di3[x]!=di2[x]:
        print(x)
        break