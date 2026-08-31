a, b = map(int, input().split())
cand = a
while(a // b != 0):
    cand += (a // b)
    a = (a//b) + (a % b)
print(cand)