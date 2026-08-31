n = int(input())
s = input()
k = 0

for i in s:
    if i == "8":
        k += 1
        
print(min(n // 11, k))