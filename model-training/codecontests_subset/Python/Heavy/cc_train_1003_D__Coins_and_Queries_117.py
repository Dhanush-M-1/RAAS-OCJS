import sys
input=sys.stdin.buffer.readline
n,q=map(int,input().split())
arr=list(map(int,input().split()))
store=[0 for i in range(31)]
d={}
for i in range(31):
    d[pow(2,i)] =i
for i in range(n):
    store[d[arr[i]]] +=1
for i in range(q):
    rt=int(input())
    st=bin(rt).replace("0b","")
    st=st[::-1]
    count=0
    manage=[0 for i in range(31)]
    for i in st:
        if i==str(1):
            manage[count] =1
        count +=1
    total =0
    for i in range(30,-1,-1):
        if manage[i] >0 and i>0:
            total +=min(manage[i],store[i])
            manage[i] =max(0,manage[i] -store[i])
            manage[i-1] +=2*manage[i]
            manage[i] =0
    if manage[0] >store[0]:
        print(-1)
        continue
    print(total +manage[0])
