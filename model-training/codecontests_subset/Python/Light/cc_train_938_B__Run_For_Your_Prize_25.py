n=int(input())
x=input().split(' ')
for i in range(n):
    x[i]=int(x[i])
x.sort()

l = []
for i in range(0, len(x)):
    l.append(min(x[i]-1, 1000000-x[i]))

print(max(l))
