n,k=list(map(int,input().split(" ")))
a=input().split(" ")
a=list(map(int,a))
l=[]
for i in range (n):
    if(k%a[i]==0):
        l.append(int(k/a[i]))
# print(l)
print(min(l))