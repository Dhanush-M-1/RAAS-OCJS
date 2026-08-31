t=int(input())
for i in range(t):
    n=int(input())
    ar=[]
    for j in range(n):
        ar.append([int(k) for k in input().split()])
    flag=0
    i=0
    if n==0:
        print("YES")
        continue
    if ar[0][0]<ar[0][1]:
        print("NO")
        continue
    i=1
    while(i<n):
        if ar[i][0]<ar[i-1][0] or ar[i][1]<ar[i-1][1] or ar[i][0]-ar[i-1][0]<ar[i][1]-ar[i-1][1]:
            flag=1
            break
        i+=1
    if flag==0:
        print("YES")
    else:
        print("NO")