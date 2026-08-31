n=int(input())
l=[]
for i in range (n):
    l.append(list(map(int,input().split())))  
if n<3:
    print(n)
else:
    count=2
    for j in range(1,n-1):
        if l[j][0]-l[j][1]>l[j-1][0]:
            count+=1
        elif l[j][0]+l[j][1]<l[j+1][0]:
            count+=1
            l[j][0]=l[j][0]+l[j][1]
        else:
            continue
    print(count)