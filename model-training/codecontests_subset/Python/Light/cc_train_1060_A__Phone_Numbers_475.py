n=int(input())
s=input()

k=0
for e in s:
    if e=='8':
        k=k+1
r=n-k
a=r//10

if a>k:
    print(k)
else:
    print(n//11)