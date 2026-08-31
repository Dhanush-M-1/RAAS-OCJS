t = int(input())
for i in range(t):
    n = int(input())
    lis = list(map(int,input().split()))
    maxi = 0
    tempLis = []
    for j in range(0,n-1):
        if lis[j]!=-1 and lis[j+1]!=-1:
            if abs(lis[j]-lis[j+1])>maxi:
                maxi = abs(lis[j]-lis[j+1])
        elif lis[j]==-1 and lis[j+1]!=-1:
            tempLis.append(lis[j+1])
        elif lis[j]!=-1 and lis[j+1]==-1:
            tempLis.append(lis[j])
    if len(tempLis)==0:
        print(0,end=" ")
        print(0)
        continue
    tempMax = max(tempLis)
    tempMin = min(tempLis)
    k = int((tempMax+tempMin)/2)
    m = max(maxi,abs(tempMax-k),abs(tempMin-k))
    print(m,end=" ")
    print(k)     
    