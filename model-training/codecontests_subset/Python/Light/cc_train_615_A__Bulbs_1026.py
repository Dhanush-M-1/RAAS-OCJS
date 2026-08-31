n,m=[int(x) for x in input().split()]
a=[]
for i in range(n):
    b=[int(x) for x in input().split()]
    a=a+b[1:]
    
a=set(a)
print("YES" if len(a)==m else "NO")