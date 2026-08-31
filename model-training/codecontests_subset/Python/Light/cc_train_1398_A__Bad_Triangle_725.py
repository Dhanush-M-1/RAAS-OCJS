try:
    for _ in range(int(input())):
        a=int(input())
        b=list(map(int,input().split()))
        i=0
        k=a-1 
        flag=True
        j=a-2
        while flag and i<j and j<k:
            temp=b[k]-b[i]
            if b[j]<=temp:
                print(i+1,j+1,k+1)
                flag=False 
            else:
                j-=1 
        if flag:
            print(-1)
except Exception as e:
    print(e)