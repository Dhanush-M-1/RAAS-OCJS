n = int(input())
s = input()
k = 0
d = n // 11
for i in s:
    if i == "8": k +=1
print(min(k,d))