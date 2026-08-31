'''Author- Akshit Monga'''
t = 1
for _ in range(t):
    n,k=map(int,input().split())
    arr=[]
    for i in range(n):
        a,b,c=map(int,input().split())
        arr.append((a,b,c))
    arr=sorted(arr,key=lambda x:x[0])
    ans=0
    x=y=k
    counter=0
    temp1=[]
    temp2=[]
    # print(arr)
    while(counter<n):
        if x<=0 and y<=0:
            break
        if arr[counter][1]==0 and arr[counter][2]==0:
            counter+=1
            continue
        ans+=arr[counter][0]
        x-=arr[counter][1]
        y-=arr[counter][2]
        if arr[counter][1] and not arr[counter][2]:
            temp1.append(arr[counter][0])
        elif not arr[counter][1] and arr[counter][2]:
            temp2.append(arr[counter][0])
        counter += 1
    x_d=min(len(temp1),len(temp2))
    ans-=sum(temp1)+sum(temp2)
    temp1=temp1[0:x_d]
    temp2=temp2[0:x_d]
    ans += sum(temp1) + sum(temp2)
    if len(temp1)>0 and len(temp2)>0:
        temp1 = sorted(temp1)
        temp2 = sorted(temp2)
        for i in range(counter, n):
            if arr[i][1] == 1 and arr[i][2] == 1:
                if arr[i][0]<temp1[-1]+temp2[-1]:
                    ans+=arr[i][0]-(temp1[-1]+temp2[-1])
                    temp1.pop()
                    temp2.pop()
                    if not (len(temp1) and len(temp2)):
                        break

    if x>0 or y>0:
        print(-1)
    else:
        print(ans)