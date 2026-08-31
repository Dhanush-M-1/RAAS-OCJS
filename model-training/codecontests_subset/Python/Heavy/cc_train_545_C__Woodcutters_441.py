n=int(input())
if n==1:
    print(1)
else:
    xh_pair=[]
    for i in range(n):
        xh_pair.append([int(x) for x in input().split()])
    nCount=1
    i=1
    while i<=n-2:
        if xh_pair[i][0]-xh_pair[i][1]>xh_pair[i-1][0]:
            xh_pair[i][0]=xh_pair[i][0]
            nCount+=1
        else:
            if xh_pair[i][0]+xh_pair[i][1]<xh_pair[i+1][0]:
                xh_pair[i][0]+=xh_pair[i][1]
                nCount+=1
            else:
                pass
        i+=1
    nCount+=1
    print(nCount)
