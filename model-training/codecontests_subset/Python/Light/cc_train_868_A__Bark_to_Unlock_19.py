s = input()
n = int(input())
l = [input() for _ in range(n)]
res = any(s in l[i] + l[j] for i in range(n) for j in range(n))
print("YES" if res else "NO")