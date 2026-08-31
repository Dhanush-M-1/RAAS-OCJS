for _ in range(int(input())):
    l,r,d=map(int,input().split())
    l,r=min(l,r),max(l,r)
    temp1=l//d
    temp2=r//d
    #print(temp1,temp2)
    if(d*temp1==l):
        temp1-=1
    if(d*temp2<=r):
        temp2+=1
    flag=0
    #print(temp1,temp2)
    for q in range(1,temp1+1):
        print(d*q)
        flag=1
        break
    if(flag):
        continue
    print(d*temp2)