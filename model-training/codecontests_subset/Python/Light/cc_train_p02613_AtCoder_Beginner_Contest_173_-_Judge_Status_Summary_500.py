N = int(input())
s = list()
for _ in range(N):
  s.append(input())
for result in ("AC","WA","TLE","RE"):
	print(f"{result} x {s.count(result)}")