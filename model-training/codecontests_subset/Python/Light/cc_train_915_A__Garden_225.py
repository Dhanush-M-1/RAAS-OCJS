n,k=map(int,input().split())
l=list(map(int,input().split()))
x=0
z=0
for i in l:
    if k%i==0:
        if z<i:
            z=i
x=k//z 
print(x)
    
