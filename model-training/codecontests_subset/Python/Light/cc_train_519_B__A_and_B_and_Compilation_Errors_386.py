a = int(input())
s1 = input().split()
s2 = input().split()
s3 = input().split()
d1={}
d2={}
d3={}
for i in s1:
    if i in d1:
        d1[i]+=1
    else:
        d1[i]=1
for i in s2:
    if i in d2:
        d2[i]+=1
    else:
        d2[i]=1
for i in s3:
    if i in d3:
        d3[i]+=1
    else:
        d3[i]=1
for i in d1:
    if not i in d2:
        print(i)
    else:
        if d1[i]!=d2[i]:
            print(i)
for i in d2:
    if not i in d3:
        print(i)
    else:
        if d2[i]!=d3[i]:
            print(i)
