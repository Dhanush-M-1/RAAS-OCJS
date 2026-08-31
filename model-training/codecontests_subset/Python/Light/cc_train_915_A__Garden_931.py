n,l=map(int,input().split());a=[]
b=list(map(int,input().split()));
for i in b:
    if l%i==0:
        a.append(i)
a.sort()
print(int(l/(a[len(a)-1])))