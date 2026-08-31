n = int(input())
inp = input()
a = 0
for i in range(n):
    if inp[i] == "8": a+=1
b = n//11
print(a) if b>a else print(b)
