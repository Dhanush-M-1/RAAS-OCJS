for _ in range(int(input())):
    n=int(input())
    l=[]
    for i in range(n):
        l1=list(map(int,input().split()))
        l.append(l1)
    i=0
    f=0
    while(i<n-1):
        if(l[i][0]<l[i][1]):
            f=1
            break
        elif(l[i+1][0]<l[i][0] or l[i+1][1]<l[i][1]):
            f=1
            break
        elif((l[i+1][0]-l[i][0])<(l[i+1][1]-l[i][1])):
            f=1
            break
        i+=1
    if(l[i][0]<l[i][1]):
        f=1
    if(f==1):
        print("NO")
    else:
        print("YES")