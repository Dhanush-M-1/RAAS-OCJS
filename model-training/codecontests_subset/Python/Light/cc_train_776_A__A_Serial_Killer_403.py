
a=list(map(str,input().split()))
n=int(input())
print(*a)
for i in range(n):
    s,r=map(str,input().split())
    a.remove(s)
    a.append(r)
    print(*a)
