n,k = list(map(int,input().split(' ')))
c=0
i =1
c=n
while i >0:
    rem = n%k
    n = n//k
    c=c+n
    n = rem+n
    if n<k:
        break
print(c)