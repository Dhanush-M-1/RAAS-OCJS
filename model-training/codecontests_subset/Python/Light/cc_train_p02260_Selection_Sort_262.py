#65
#ALDS1_2_B
n=int(input())
*a,=list(map(int,input().split()))
flag=0

for i in range(n):
    m=i
    for j in range(i,n):
        if a[m]>a[j]:m=j
    
    if i!=m:
        a[m],a[i]=a[i],a[m]
        flag+=1

print(*a)
print(flag)
        
