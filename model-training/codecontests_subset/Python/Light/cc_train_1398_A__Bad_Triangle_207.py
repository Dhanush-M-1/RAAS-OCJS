for j in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    if len(l)==3:
        if l[0]+l[1]<=l[2]:
            print(1,2,3)
        else:
            print(-1)
    else: 
        x=0
        for i in range(len(l)-2):
            if l[i]+l[i+1]<=l[-1]:
                print(i+1,i+2,len(l))
                x=1
                break
        if x==0:
            print(-1)