p1,p2=map(str, input().split(" "))
n=int(input())
print(p1,p2)
while(n):
    v1,v2=map(str, input().split(" "))
    if(v1==p1):
        p1=v2
        print(p1,p2)
    if(v1==p2):
        p2=v2
        print(p1,p2)
    n-=1