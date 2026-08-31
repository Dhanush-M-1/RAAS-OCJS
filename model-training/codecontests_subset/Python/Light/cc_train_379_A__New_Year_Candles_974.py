a , b = input().split()

a = int(a)
b = int(b)
n = a
k = 0
ans = 0

while n != 0:
    n -=1
    k +=1
    if k == b:
        k = 0
        n +=1
    ans +=1
print(ans)