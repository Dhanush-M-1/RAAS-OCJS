v=list(map(str,input().split()))
n=int(input())
print(*v)
for i in range(n):
    v1,v2=map(str,input().split())
    if v1 in v:
        v.remove(v1)
        v.append(v2)
        print(*v)