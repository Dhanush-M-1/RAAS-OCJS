n = int(input())
for i in range(1, n): print(*[(i * j // n) * 10 + (i * j % n) for j in range(1, n)])