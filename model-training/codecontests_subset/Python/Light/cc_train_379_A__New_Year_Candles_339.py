n, m=map(int, input().split())
k=0
for i in range(2000):
    if n>0:
        k+=1
        n-=1
        if i%m==0:
            n+=1
else:
    print(k-1)