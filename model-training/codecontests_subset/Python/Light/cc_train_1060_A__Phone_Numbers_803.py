n = int(input())
s = list(map(int, input()))
print(min(s.count(8), (len(s) // 11)))