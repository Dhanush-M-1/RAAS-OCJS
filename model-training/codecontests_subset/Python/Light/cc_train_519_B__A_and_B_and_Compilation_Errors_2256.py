n=int(input())

o = list(map(int,input().split()))
t = list(map(int,input().split()))
th = list(map(int,input().split()))

d1={}
d2={}
d3={}

for i in o:
    if i in d1:
        d1[i]+=1
    else:
        d1[i]=1
for i in t:
    if i in d2:
        d2[i]+=1
    else:
        d2[i]=1

for i in th:
    if i in d3:
        d3[i]+=1
    else:
        d3[i]=1


for key in d1.keys():
    if key in d2:
        if d1[key]!=d2[key]:
            print(key)
            break
    else:
        print(key)

for key in d2.keys():
    if key in d3:
        if d2[key]!=d3[key]:
            print(key)
            break
    else:
        print(key)
