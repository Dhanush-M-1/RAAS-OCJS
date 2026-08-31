for t in range(int(input())):
    n,m=list(map(int,input().split()))
    a=list(map(int,input().split()))
    b=list(map(int,input().split()))
    a=sorted(a)
    b=sorted(b)
    flag=0
    for i in range(m):
        for j in range(n):
            if b[i]>a[j]:
                continue
            else:
                if b[i]==a[j]:
                    flag=1
                    break
                else:
                    #print(a[j])
                    break
            
        #print(b[i])
        if(flag==1):
            print("YES")
            print(1,b[i])
            break
    if (flag==0):
        print("NO")