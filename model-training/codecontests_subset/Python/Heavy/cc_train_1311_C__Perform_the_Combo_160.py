from sys import stdin,stdout
for _ in range(int(stdin.readline())):
    # n=int(stdin.readline());
    n,m=list(map(int,stdin.readline().split()))
    s=input();d=[0]*(n+1)
    a=list(map(int,stdin.readline().split()))
    for v in a:
        d[0]+=1
        d[v]-=1
    for i in range(1,n):
        d[i]+=d[i-1]
    # print(d)
    freq={}
    for i in range(n):
        freq[s[i]]=freq.get(s[i],0)+d[i]+1
    for ch in range(97,123):
        f=freq.get(chr(ch),0)
        stdout.write(str(f)+' ')
    print()