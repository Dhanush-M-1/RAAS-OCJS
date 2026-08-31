n=int(input())
a=list(map(int, input().strip().split(' ')))
b=list(map(int, input().strip().split(' ')))
c=list(map(int, input().strip().split(' ')))
b=b+[0]
c=c+[0]+[0]
s1=0
s2=0
for x in range(0,n):
    s1=s1+a[x]-b[x]
    s2=s2+b[x]-c[x]
print(s1)
print(s2)
    
