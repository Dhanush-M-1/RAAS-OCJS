y=list(map(int,input().split()))
z=list(map(int,input().split()))
p=[]
for i in z:
    if y[1]%i==0:
        p.append(y[1]//i)
print(min(p))
