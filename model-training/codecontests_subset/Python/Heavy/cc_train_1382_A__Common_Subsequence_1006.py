t=int(input())
while(t):
    n1,n2=map(int,input().split())
    l1=list(map(int,input().split()))
    l2=list(map(int,input().split()))
    c=0
    if(len(l1)>=len(l2)):
        for i in range(len(l1)):
            for j in range(len(l2)):
                if (l1[i] == l2[j]):
                    c += 1
                    ans = l1[i]
                    break
    else:
        for i in range(len(l2)):
            for j in range(len(l1)):
                if (l2[i] == l1[j]):
                    c += 1
                    ans = l2[i]
                    break
    if(c==0):
        print("NO")
    else:
        print("YES")
        print(1,ans)
    t=t-1
