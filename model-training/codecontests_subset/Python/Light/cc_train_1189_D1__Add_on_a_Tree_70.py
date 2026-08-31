n=int(input())
dic={}
for x in range(n-1):
    a,b=list(map(int,input().split()))
    if a in dic:
        dic[a]+=1
    else:
        dic[a]=1
    if b in dic:
        dic[b]+=1
    else:
        dic[b]=1
flag=5
for it in dic:
    if dic[it]==2:
        flag=6
        break
if flag==6:
    print("NO")
else:
    print("YES")