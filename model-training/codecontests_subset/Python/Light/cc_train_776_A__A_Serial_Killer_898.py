s=list(input().split())
print(*s)
n=int(input())
for i in range(n):
    ss=list(input().split())
    s.remove(ss[0])
    s.append(ss[1])
    print(*s)