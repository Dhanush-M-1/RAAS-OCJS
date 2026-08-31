n=int(input())
a=list(map(int,input().split()))[:n]
d=sum(a)
for i in range(2):
    a=list(map(int,input().split()))
    c=sum(a)
    print(d-c)
    d=c
    
