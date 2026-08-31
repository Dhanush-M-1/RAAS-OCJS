n=int(input())
x = [int(x) for x in input().split()]
s=0
for i in range(n):
    s+=x[i];

s1=0
x = [int(x) for x in input().split()]
for i in range(n-1):
    s1+=x[i]
print(s-s1)
s=s1

s1=0
x = [int(x) for x in input().split()]
for i in range(n-2):
    s1+=x[i]
print(s-s1)
