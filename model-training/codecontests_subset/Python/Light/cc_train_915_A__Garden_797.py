n,k=map(int,input().split(' '))
b=0
l=map(int,input().split(' '))
for i in l:
    
    if (i>b)& (k%i==0) :
        b=i
print(int(k/b))
