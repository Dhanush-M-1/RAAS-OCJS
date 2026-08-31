l=[]
temp=[]
t=list(map(str,input().split()))
n=int(input())
print(*t)
for _ in range(n):
    a,b=map(str,input().split())
    if a not in t:
        if(b==t[0]):
            t[0]=a
            print(*t)
        else:
            t[1]=a
            print(*t)
    else:
        if(a==t[0]):
            t[0]=b
            print(*t)
        else:
            t[1]=b
            print(*t)

