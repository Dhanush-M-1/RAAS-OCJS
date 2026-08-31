
n = int(input())
str = input()
num = int(n//11)
for i in range(len(str)):
    n8 = str.count(f"{8}")
min = min(num,n8)
print(min)


