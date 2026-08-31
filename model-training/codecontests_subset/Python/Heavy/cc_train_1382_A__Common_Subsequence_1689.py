test=int(input())
for t in range(test):
    lis=input().split()
    a=int(lis[0])
    b=int(lis[1])
    arr=input().split()
    brr=input().split()
    dic1={}
    dic2={}
    for i in arr:
        if i not in dic1:
            dic1[i]=1
        else:
            dic1[i]+=1
    for i in brr:
        if i not in dic2:
            dic2[i]=1
        else:
            dic2[i]+=1 
    flag=0        
    for i in dic1:
        if i in dic2:
            print("YES")
            print("1",end=" ")
            print(i)
            flag=1
            break
    if flag==0:    
        print("NO")    