n = int(input())
s = input()
a = [0] * 10
m = 0
for i in range(n):
    a[int(s[i])-1] += 1
x = a[7]
s = sum(a)//11
print(min(x,s))