
n , k = map(int , input().split())

a = [int(a) for a in input().split()]

mn = k

for i in a:
    if k % i == 0:
        mn = min(mn , k // i)
        
print(mn)