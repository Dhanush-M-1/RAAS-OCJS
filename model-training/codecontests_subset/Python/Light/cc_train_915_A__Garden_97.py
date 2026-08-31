n,k=map(int,input().split())
l=list(map(int,input().split()))
p=[]
for i in l:
            if k%i==0:
                        p.append(i)
x=max(p)
print(int(k/x))