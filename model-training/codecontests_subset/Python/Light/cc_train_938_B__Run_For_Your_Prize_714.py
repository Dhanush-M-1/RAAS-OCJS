#938B
n=int(input())
a=list(map(int,input().split()))
b1=0;b2=1000000
for i in range(n):
    if a[i]<=(1000000//2):
        b1=a[i]
    else:
        i-=1
        break
for j in range(i+1,n):
    b2=a[j]
    break
print(max(b1-1,1000000-b2))
    
    
    
    