n = int(input())
aa = [int(i) for i in input().split()]
dic = {}
for i in range(0,n):
    if aa[i] not in dic:
        dic[aa[i]] = [i]
    else:
        dic[aa[i]].append(i)
ll = sorted(dic)[::-1]
m = int(input())
for _ in range(0,m):
    k,pos = map(int,input().split())
    ans = []
    for i in range(0,len(ll)):
        if len(dic[ll[i]]) < k:
            ans += dic[ll[i]]
            k -= len(dic[ll[i]])
        else:
            ans += dic[ll[i]][:k]
            break
    print(aa[sorted(ans)[pos-1]])