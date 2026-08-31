n,k=map(int,input().split())
ai=list(map(int,input().split()))
bi=[]
for i in ai :
    if(k%i==0):
        bi.append(i)
print(int(k/max(bi)))