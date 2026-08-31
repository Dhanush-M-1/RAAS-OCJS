n=int(input())
strk=[]
result=0
for i in range(n):
    k=input().split()
    for j in k:
        strk.append(int(j))
    if strk[2]<strk[0]:
        result=strk[2]
    if result==0:
        if strk[0]<=strk[2]<=strk[1]:
            result=strk[2]*(strk[1]//strk[2]+1)
    if result==0:
        if strk[2]>strk[1]:
            result=strk[2]
    print(result)
    result=0
    strk=[]