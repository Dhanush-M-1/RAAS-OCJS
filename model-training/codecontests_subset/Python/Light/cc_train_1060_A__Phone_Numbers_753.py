n = int(input())
s = input()
k = 0
for c in s:
    if c == "8":
        k +=1

print(min(k, n //11))