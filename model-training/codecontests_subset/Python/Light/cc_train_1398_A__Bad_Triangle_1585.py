t=int(input())
for _ in range(t):
    n=int(input())
    li=list(map(int,input().split()))
    i=0
    j=1
    k=n-1
    while(k>j):
        if li[i]+li[j]<=li[k]:
            break
        else:
            i=j
            j+=1
    if k>j:
        print(i+1,j+1,k+1)
    else:
        print(-1)
