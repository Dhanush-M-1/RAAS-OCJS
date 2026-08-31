for _ in range(int(input())):
    a,b=map(int,input().split())
    l=list(input())
    a=list(map(int,input().split()))
    alpha=[0]*26
    a=sorted(a)
    prev=0
    for i in range(len(l)):
        flag=0
        for j in range(prev,len(a)):
            #print(prev)
            if i<=a[j]-1:
                prev=j
                flag=1
                break
        if(flag==1):
            alpha[ord(str(l[i]))-97]+=(len(a)-j)
        #print(i, a[j]-1)
        #print(alpha)
    for i in range(len(l)):
        alpha[ord(str(l[i]))-97]+=1
    for i in alpha:
        print(i,end=" ")
    print(" ")
        
        