names=input().split()
n=int(input())
a=[names[:]]

for i in range(n):
    c,d=input().split()
    names.remove(c)
    names.append(d)
    a.append(names[:])
for i in a:
    print(i[0],i[1])
    
