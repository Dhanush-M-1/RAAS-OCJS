n = int(input())
a = input()
x = 0
for i in a:
    if i == "8":
        x += 1
print(min(x , n // 11))
