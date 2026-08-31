x = 1; y = int(1e6)
a = -1; b = 1e50;
n = int(input())
array = list(map(int, input().split()))
for i in array:
    if i <= y//2:
        a = max(a, i)
    else:
        b = min(b, i)
b = y - b 
a = a-1
print(max(a,b))