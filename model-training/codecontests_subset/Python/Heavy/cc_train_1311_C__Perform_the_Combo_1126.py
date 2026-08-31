test=int(input())
for i in range(test):
    [s,k]=list(map(int,input().split()))
    arr=input()
    brr=list(map(int,input().split()))
    has=[0]*(max(brr)+1)
    for j in range(k):
        has[brr[j]]+=1
    hold=0
    for j in range(len(has)-1,-1,-1):
        if has[j]!=0:
            has[j]+=hold
            hold=has[j]
        else:
            has[j]=has[j+1]
    #print(has)
    del(has[0])
    ans=[0]*26
    for j in range(len(has)):
        ans[ord(arr[j])-97]+=has[j]
    for j in range(s):
        ans[ord(arr[j])-97]+=1
    print(*ans)