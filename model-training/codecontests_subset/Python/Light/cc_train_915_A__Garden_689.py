a=list(map(int,input().split()))
b=list(map(int,input().split()))
s=[]
temp=0
for i in range(a[0]):
    if(a[1]%b[i]==0):
        s.append(int(a[1]//b[i]))
print(min(s))
