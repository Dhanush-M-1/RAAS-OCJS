l=[]
n=int(input())
for _ in range(n):
    l.append(list(map(int,input().split())))
if n<=2 :
    print(n)
else:
    count=2
    occupied=l[0][0]
    for i in range(1,n-1):
        if l[i][0]-l[i-1][0]>l[i][1] and l[i][0]-l[i][1]>occupied :
            #print(l[i])
            count+=1
        elif l[i+1][0]-l[i][0]>l[i][1] :
            count+=1
            occupied=l[i][0]+l[i][1]
            #print(l[i])
    print(count)