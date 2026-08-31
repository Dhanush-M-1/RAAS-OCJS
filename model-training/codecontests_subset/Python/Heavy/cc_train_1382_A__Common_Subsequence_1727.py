t=int(input())
for test in range(t):
    n,m=map(int,input().split())
    l=list(map(int,input().split()))
    li=list(map(int,input().split()))
    l.sort()
    #l=l[::-1]
    li.sort()

    #li=li[::-1]
    flag=0
    ls=[]
    for i in range(len(l)):
        for j in range(len(li)):
            if l[i]==li[j]:
                flag=1
                ls.append(l[i])
                #print("YES")
                #print(1,l[j])
                break
    if flag==1:
        print("YES")
        print(1,ls[0])
        
    if flag==0:
        print("NO")
    