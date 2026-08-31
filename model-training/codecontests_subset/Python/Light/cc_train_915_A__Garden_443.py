n,k=map(int,input().split())
li=map(int,input().split())
lo=sorted(li)
for i in range(n):
    m = int(lo[n-i-1])
    if k%m==0:
        print(int(k/m))
        break



