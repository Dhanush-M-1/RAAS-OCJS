l=input().split()
print(*l)
for i in range(int(input())):
    s,t=input().split()
    l[l.index(s)]=t
    print(*l)