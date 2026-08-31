s = list(map(str, input().split()))
n = int(input())
print(*s)
for i in range(n):
    dell, neww = map(str, input().split())
    s[s.index(dell)] = neww
    print(*s)
    
