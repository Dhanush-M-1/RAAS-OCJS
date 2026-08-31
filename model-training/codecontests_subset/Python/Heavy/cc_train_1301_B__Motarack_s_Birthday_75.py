for t in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    if a.count(-1)==n:
        print(0,0)
    else:
        arr=[]
        for i in range(1,n):
            if a[i]!=-1 and a[i-1]==-1:
                arr.append(a[i])
            elif a[i]==-1 and a[i-1]!=-1:
                arr.append(a[i-1])

        avg=(max(arr)+min(arr))//2
        for i in range(n):
            if a[i]==-1:
                a[i]=avg

        maxi=abs(a[1]-a[0])

        for i in range(2,n):
            diff=abs(a[i]-a[i-1])
            if diff>maxi:
                maxi=diff

        print(maxi,avg)