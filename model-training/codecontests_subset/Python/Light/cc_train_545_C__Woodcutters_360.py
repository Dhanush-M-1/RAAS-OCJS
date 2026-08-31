

if __name__=="__main__":
    n=int(input())
    l=[]
    for i in range(n):
        c=[int(x) for x in input().split()]
        l.append(c)
    cnt=1

    pv=l[0][0]
    for i in range(1,n-1):
        if(l[i][0]-l[i][1]>pv):
            cnt+=1
            pv=l[i][0]
        elif(l[i][0]+l[i][1]<l[i+1][0]):
            cnt+=1
            pv=l[i][0]+l[i][1]
        else:pv=l[i][0]
    if n>1: cnt+=1
    print(cnt)
