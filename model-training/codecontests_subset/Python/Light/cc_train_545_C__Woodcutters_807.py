n=int(input())

pair=[]
for i in range(n):
    x,h=map(int,input().split())
    pair.append((x,h))

nCount=1
pre=pair[0][0]
for index in range(1,n-1):
    i=pair[index]
    j=pair[index+1]
    if i[0]-pre>i[1]:
        nCount+=1
        pre=i[0]
        continue
    if i[0]+i[1]<j[0]:
        nCount+=1
        pre=i[0]+i[1]
        continue

    pre=i[0]

if n==1:
    print(1)
else:
    print(nCount+1)