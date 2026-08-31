t=int(input())
for i in range(t):
    n=int(input())
    list1=list(map(int,input().split()))
    for i in range(n-1):
        j=i+1
        if (list1[i]+list1[j])>list1[n-1]:
            print(-1)
            break
        else:
            print(i+1,j+1,n)
            break