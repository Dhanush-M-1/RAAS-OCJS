n,k=map(int,input().split(' '))
h=1
l=input()
l=l.split()
for i in range(n):
    a=int(l[i])
    if (k%a==0):
        if (h<a):
            h=a
print(int(k/h))
        