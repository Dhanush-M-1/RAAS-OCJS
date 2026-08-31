n=int(input())
a=list(map(int,input().split()))
m1=0
m2=10000000
for i in a:
    if i<=500000 and i>m1:
        m1=i
    if i>500000 and i<m2:
        m2=i
print(max(m1-1,1000000-m2))
        
