n=int(input())
p1=1
p2=1000000
time=0
k=list(map(int,input().split()))
for i in range(len(k)):
    if k[i]>=500001:
        if time<p2-k[i]:
            time=p2-k[i]
    else:
        if time<k[i]-p1:
            time=k[i]-p1
print(time)