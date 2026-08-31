n = int(input())
s = input()
k = 0

for i in range(len(s)):
    if s[i]=='8':
        k+=1

def min(a, b):
    if a < b:
        return a
    return b

print(min(n//11, k))
