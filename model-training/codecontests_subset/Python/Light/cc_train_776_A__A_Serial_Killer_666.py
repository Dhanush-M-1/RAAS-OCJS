a, b = input().split()
n = int(input())
last = (a, b)
print(a, b)
for i in range(n):
    s = input().split()
    x = 1 - last.index(s[0])
    last = (last[x], s[1])
    print(last[0], last[1], sep = " ")
    
    
