s=set(input().split())
n=int(input())
print(*s)
for i in range(n):
    a,b=input().split()
    s^={a}
    s.add(b)
    print(*s)
    
    
