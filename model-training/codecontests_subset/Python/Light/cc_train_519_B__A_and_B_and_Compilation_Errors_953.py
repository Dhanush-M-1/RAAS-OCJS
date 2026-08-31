n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
x = 0
for i in a:
    x^=i
for i in b:
    x^=i 
print(x)

x = 0
for i in b:
    x^=i
for i in c:
    x^=i 
print(x)