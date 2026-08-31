n,k = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
cnt = 0
for i in a:
    if(k%i==0):
        cnt = int(k/i)
print(cnt)