a, b = input().split()
a = int(a)
b = int(b)
t=a
n=0 #chas
k=0
while a>0  :
    a=a-1
    n=n+1
    k=k+1
    if k%b==0:
        a=a+1
print(n)
