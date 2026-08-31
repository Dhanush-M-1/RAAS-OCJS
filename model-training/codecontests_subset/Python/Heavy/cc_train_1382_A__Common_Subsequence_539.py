for t in range (int(input())):
    n1,n2=map(int,input().split())
    l1=list(map(int,input().split()))
    l2=list(map(int,input().split()))
    count=0
    if(n1<=n2):
        for i in range (n1):
            if(l1[i] in l2):
                count=1
                print("YES")
                print(1,end=" ")
                print(l1[i])
                break
    elif(n1>=n2):
        for i in range (n2):
            if(l2[i] in l1):
                count=1
                print("YES")
                print(1,end=" ")
                print(l2[i])
                break
    if(count==0):
        print("NO")