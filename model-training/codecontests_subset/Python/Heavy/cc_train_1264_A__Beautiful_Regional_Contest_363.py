def f(L):
    M=[1]
    n=len(L)
    if n<3:return [0,0,0]
    medals=[0,0,0]
    counter=0
    for i in range(1,len(L)):
        if L[i-1]==L[i]:M[-1]+=1
        else:M.append(1)
    if len(M)<3:return[0,0,0]
    medals[0]=M[0]
    medals[1]=M[1]
    counter=M[0]+M[1]
    k=2
    while medals[0]>=medals[1] and k<len(M):
        medals[1]+=M[k]
        counter+=M[k]
        k+=1
    if counter*2>n:return[0,0,0]
    if medals[0]>=medals[1]:return[0,0,0]
    else:
        while counter*2<=n and k<len(M):
            if (counter+M[k])*2<=n:
                counter+=M[k]
                medals[2]+=M[k]
                k+=1
            else:break
    if medals[2]<=medals[0]:return [0,0,0]
    else:return medals

for i in ' '*int(input()):
    n=int(input())
    for i in (f(list(map(int,input().split())))):
        print(i,end=' ')
    print()