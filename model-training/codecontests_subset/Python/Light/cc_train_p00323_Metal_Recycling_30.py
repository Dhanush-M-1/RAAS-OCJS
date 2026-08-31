N=200020
a=[0]*N
for _ in range(int(input())): a[sum(map(int,input().split()))]+=1
for i in range(N-1):
    a[i+1]+=a[i]>>1
    if a[i]&1:
        print(i,0)