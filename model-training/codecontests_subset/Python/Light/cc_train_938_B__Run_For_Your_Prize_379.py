n=int(input())
a=[int(i) for i in input().split()]
me , fr = 1, 10**6
j=0
for i in a:
    if i < 500001 and i-1 > j:
        j=i-1
    if i > 500000 and 10**6-i > j:
        j=10**6-i
print(j)
