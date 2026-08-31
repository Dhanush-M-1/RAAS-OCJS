n,m= map(int, input().split())

cnt=0
cnt+=n

while(int(n/m)!=0):
    cnt+=int(n/m)
    #print(cnt)
    n=int(n/m)+(n%m)

print(cnt)
