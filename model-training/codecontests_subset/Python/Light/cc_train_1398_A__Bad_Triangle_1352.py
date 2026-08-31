t = int(input())
for i in range(t):
    s = int(input())
    l=list(map(int,input().split()))
    if l[0]+l[1]>l[-1]:
        ans=[]
        for j in range(0,s-2):
            if l[j]+l[j+1]<=l[j+2]:
                ans=[j+1,j+2,j+3]
                break
        if ans==[]:
            print(-1)
        else:
            print(*ans)
    else:
        print(1,2,s)