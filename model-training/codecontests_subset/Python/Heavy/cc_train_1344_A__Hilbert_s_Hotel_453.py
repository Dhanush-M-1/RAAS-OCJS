nrew = int(input())
for wew in range(nrew):
    n = int(input())
    temp = list(map(int,input().split(" ")))
    li = [0]*n
    flag = 0
    for i in range(len(temp)):
        mod = 0
        if(temp[i]<0):
            mod = n- abs(temp[i])%n
        else:
            mod = temp[i]%n
        #print("mod" , mod)
        tr = mod + i
        #print("tr  :" , tr)

        if(tr>=n):
            tr-=n
        li[tr]+=1
        if(li[tr]>1):
            flag = 1
            #print("herere  " , tr , " tr   i",i)
            break
    #print(li)
    if(flag==1):
        print("NO")
    else:
        print("YES")