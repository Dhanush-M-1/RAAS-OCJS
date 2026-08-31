n=int(input())
l=[]
for i in range(n):
    lo=input().split()
    l.append((int(lo[0]),int(lo[1])))
l.insert(0,(-1*10**9,0))
l.append((3*10**9,0))
curr=-1*(10**9)
count=0
for i in range(1,n+1):
    if(l[i][0]-l[i][1]>curr):
        count+=1
        curr=l[i][0]
    elif(l[i+1][0]-l[i][1]>l[i][0]):
        count+=1
        curr=l[i][0]+l[i][1]
    else:
        curr=l[i][0]
print(count)
