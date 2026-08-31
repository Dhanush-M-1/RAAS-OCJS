def process():
    n=int(input())
    li=list(map(int,input().split()))
    li.sort()
    hashi={}
    c0=1
    for i in li:
        if i in hashi:
            hashi[i].append(c0)
        else:
            hashi[i]=[c0]
        c0+=1
    a,b,c=li[0],li[1],li[-1]
    if(a+b>c):
        print("-1")
    else:
        ans=[hashi[a].pop(),hashi[b].pop(),hashi[c].pop()]
        ans.sort()
        print(ans[0],ans[1],ans[2])

tests=int(input())
for i in range(tests):
    process()