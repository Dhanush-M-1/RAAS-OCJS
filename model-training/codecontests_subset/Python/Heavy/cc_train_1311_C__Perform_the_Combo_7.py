import string
t=int(input())
for tt in range(t):
    n,m=map(int,input().split())
    s=input()
    p=list(map(int,input().split()))
    se=set(p)
    dic={}
    for i in p:
        if i-1 in dic:
            dic[i-1]+=1
        else:
            dic[i-1]=1
    # print(dic)
    alphs=dict.fromkeys(string.ascii_lowercase, 0)
    balphs=dict.fromkeys(string.ascii_lowercase, 0)

    for i in range(len(s)):
        balphs[s[i]]+=1

        if i in dic:
            # print(i,"st",alphs)

            for k in alphs:
                if balphs[k]!=0:
                    alphs[k]+=(balphs[k])*dic[i]
            # print("b",balphs)
            # print(dic[i])
            # print(alphs)
            # print("********************")
    for i in range(len(s)):
        alphs[s[i]]+=1
    for i in alphs:
        print(alphs[i],end=' ')
    print()




