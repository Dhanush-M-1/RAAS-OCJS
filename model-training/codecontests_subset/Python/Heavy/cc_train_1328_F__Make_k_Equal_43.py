n,m = map(int,input().split())
a = list(map(int,input().split()))
mx = int(2e5)
num = [0 for _ in range(mx+1)]
numAdd = [[] for _ in range(mx+1)]
for v in a:
    num[v]+=1
    if(num[v]==m):
        print(0)
        exit()
c=0
for i in range(2,mx+1):
    if num[i]!=0:
        # print('INPUT:',i)
        cur=i
        count = 0
        while(cur!=1):
            next = cur//2
            count+=1;
            add = [count for _ in range(num[i])]
            numAdd[next] = numAdd[next] + add
            # print(next,'NUMAdd:',numAdd[next])
            cur= next

mn= int(8e9)
for i in range(1,mx+1):
    if num[i]+len(numAdd[i])>=m:
        need = m-num[i]
        my = sum(numAdd[i][:need])
        mn = min(mn,my)
print(mn)

