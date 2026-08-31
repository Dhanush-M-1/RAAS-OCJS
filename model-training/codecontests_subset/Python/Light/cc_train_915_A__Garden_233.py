[_,k]=list(map(int,input().split(' ')))
a=list(map(int,input().split(' ')))
for i in sorted(a,reverse=True):
    if k%i==0:
        break
print(k//i)
