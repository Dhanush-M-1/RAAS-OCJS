import math

n = int(input())
prizes = list( map(int, input().split()) )

first = 1
second = 1000000

for i in range(n):
    
    if prizes[i]<=500000:
        first = prizes[i]
    else:
        second = prizes[i]
        break
    
diff_1 = first - 1
diff_2 = 1000000 - second
print(max(diff_1, diff_2))
