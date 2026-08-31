t=int(input())

import math
import heapq

for _ in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))
    x=list(map(int,input().split()))
    lis=[a[0]]
    for i in range(1,n):
        lis.append(lis[-1]+a[i])
    one_round=lis[-1]
    MAX=max(lis)
    rests=[]
    ans=[]
    for q in x:
        if MAX<q:
            if one_round<=0:
                pass
                #ans.append(-1)
            else:
                round=math.ceil((q-MAX)/one_round)
                rest=q-round*one_round
                rests.append(rest)
                #print(MAX,rest,one_round,round)
                '''
                for i in range(n):
                    if rest<=lis[i]:
                        ans.append(i+round*n)
                        break
                '''
        else:
            rests.append(q)
            '''
            for i in range(n):
                if q<=lis[i]:
                    ans.append(i)
                    break
            '''
    heapq.heapify(rests)
    #print(rests)
    dic=dict()
    for i in range(n):
        while True:
            if len(rests)==0 or rests[0]>lis[i]:
                break
            temp=heapq.heappop(rests)
            dic[temp]=i
    for q in x:
        if MAX<q:
            if one_round<=0:
                ans.append(-1)
            else:
                round=math.ceil((q-MAX)/one_round)
                rest=q-round*one_round
                ans.append(dic[rest]+round*n)
                '''
                for i in range(n):
                    if rest<=lis[i]:
                        ans.append(i+round*n)
                        break
                '''
        else:
            ans.append(dic[q])
            '''
            for i in range(n):
                if q<=lis[i]:
                    ans.append(i)
                    break
            '''
    print(' '.join(str(n) for n in ans))