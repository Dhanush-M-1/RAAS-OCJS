n =int(input())
l = list(map(int,input().split()))
a = list(map(int,input().split()))
b = list(map(int,input().split()))
x = l[0]
for i in range(1,n):
    x= x^l[i]
for i in range(n-1):
    x= x^a[i]
print(x)
x=a[0]
for i in range(1,n-1):
    x=x^a[i]
for i in range(n-2):
    x=x^b[i]
print(x)