for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    s=l[0]+l[1]
    flag=0
    for i in range(2,n):
        if(s<=l[i]):
            print("1","2",i+1)
            flag=1
            break
    if(flag==0):
        print("-1")