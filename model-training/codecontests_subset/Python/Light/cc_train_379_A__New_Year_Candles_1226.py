a, b =map(int, input().split())
k = a
h = 0
while(a >= b):
    k += int(a/b)    
    a = int(a%b)+int(a/b)
print(k)
