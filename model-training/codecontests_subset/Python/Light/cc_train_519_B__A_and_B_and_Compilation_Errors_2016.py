num=int(input())
a,b,c=[],[],[]
a=input().split()
b=input().split()
c=input().split()
a.sort()
b.sort()
c.sort()
for i in range(num-1):
    if((a[i])!=(b[i])):
        print(int(a[i]))
        break
else:
    print(int(a[num-1]))
for i in range(num-2):
    if((b[i])!=(c[i])):
        print(int(b[i]))
        break
else:
    print(int(b[num-2]))