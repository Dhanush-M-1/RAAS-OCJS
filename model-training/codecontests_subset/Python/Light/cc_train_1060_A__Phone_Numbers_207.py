n = int(input())
b = input()
ate = b.count("8")
o = n - ate
f = min(ate, o // 10)
r = f
ate -= f
o -= 10 * f
if ate != 0 and ate + o >= 11:
	rr = 11 - o
	ate -= rr
	r += 1
r += ate // 11
print(r)
