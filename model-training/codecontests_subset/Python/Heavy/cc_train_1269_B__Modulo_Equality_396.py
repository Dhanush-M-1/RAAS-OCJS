n,m = map(int,input().split())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
d_b = dict()

for x in b:
    if(x in d_b):
        d_b[x]+=1
    else:
        d_b[x] = 1

d_a = dict()
for x in a:
    if(x in d_a):
        d_a[x]+=1
    else:
        d_a[x] = 1

l = []
for x in d_a:
    for y in d_b:
        if(d_a[x]==d_b[y]):
            if(x==y):
                l.append(0)
            elif(x>y):
                l.append(m-x+y)
            else:
                l.append(y-x)


d_common = dict()
for x in l:
    if(x in d_common):
        d_common[x]+=1
    else:
        d_common[x] = 0
print(max(d_common, key=d_common.get))