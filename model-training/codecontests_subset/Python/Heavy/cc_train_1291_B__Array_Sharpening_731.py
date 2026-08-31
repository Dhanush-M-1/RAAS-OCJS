for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))
    flag=0
    y=0
    ans=0
    if n==1:
        print("YES")
    elif l[(n//2)-1]==(n//2)-1 and l[n//2]==(n//2)-1 :
        print("NO")
    else:
        for i in range(0,n):
            if l[i]>=i and flag==0:
                flag=0
            else:
                flag=1 
                if l[i]>=((n-i)-1) and ((n-i)-1)>=0:
                    flag=1
                else:
                    print("NO")
                    ans=1 
                    break
        if ans==0:
            print("YES")
                    