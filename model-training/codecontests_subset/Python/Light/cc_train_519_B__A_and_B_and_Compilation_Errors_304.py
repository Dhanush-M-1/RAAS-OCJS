n = int(input())
a=0
b=0
c=0

for i in range(0,1):
    t=list(map(int,input().split()))
    a+=sum(t)

    t=list(map(int,input().split()))
    b+=sum(t)

    t = list(map(int, input().split()))
    c+=sum(t)
print(a-b)
print(b-c)
