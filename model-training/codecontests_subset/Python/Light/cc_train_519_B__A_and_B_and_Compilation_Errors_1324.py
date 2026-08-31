n=int(input())
l0=list(map(int, input().split()))
l1=list(map(int, input().split()))
l2=list(map(int, input().split()))
d={}
for i in l0:
    d[i]=[]
    d[i].append(0)
    d[i].append(0)
    d[i].append(0)
#print(d)
for i in l0:
    #print(d[i][0])
    d[i][0]+=1
for i in l1:
    d[i][1]+=1
for i in l2:
    d[i][2]+=1
for i in sorted(d.keys()):
    if((d[i][1]-d[i][0])==-1):
        a=i
    if((d[i][2]-d[i][1])==-1):
        b=i
print(a)
print(b)