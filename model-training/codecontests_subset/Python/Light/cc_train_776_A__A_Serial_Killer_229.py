a=input().split()
n=int(input())
print(' '.join(a))
for i in range(n):
    s1,s2=input().split()
    a[a.index(s1)]=s2
    print(' '.join(a))