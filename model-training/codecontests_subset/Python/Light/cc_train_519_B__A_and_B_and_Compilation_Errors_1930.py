n=int(input())
l=[]
d1={}
d2={}
d3={}
for i in range(3):
    numbers=input()
    l.append(numbers)
for x in l[0].split(" "):
    if x not in d1:
        d1[x]=1
    else:
        d1[x]+=1
for x in l[1].split(" "):
    if x not in d2:
        d2[x]=1
    else:
        d2[x]+=1
for x in l[2].split():
    if x not in d3:
        d3[x]=1
    else:
        d3[x]+=1
for x in d1:
    if x not in d2:
        print(x)
for x in d1 and d2:
    if d1[x]!=d2[x]:
        print(x)
for x in d2:
    if x not in d3:
        print(x)
for x in d2 and d3:
    if d2[x]!=d3[x]:
        print(x)
    

    
