n = int(input())
a = list(map(int,input().split()))
c = 0
min = 0
for i in range(n):
    minj = i
    for j in range(i,n):
        if a[j] < a[minj]:
            minj = j
    if(i != minj):
        a[i],a[minj] = a[minj],a[i]
        c += 1
    
print(*a)
print(c)
