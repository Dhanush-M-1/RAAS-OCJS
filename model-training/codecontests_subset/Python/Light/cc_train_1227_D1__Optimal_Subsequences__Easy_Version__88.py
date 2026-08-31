n=int(input())
s=sorted([[v,-i] for i,v in enumerate(map(int,input().split()))])
for _ in range(int(input())):
    k,i=map(int,input().split())
    ans=sorted(s[-k:],key=lambda x:-x[1])
    print(ans[i-1][0])