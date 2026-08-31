a , b = map(int, input().split())
def f(x, y):
	if x < y: return x
	return y * (x // y) + f(x - y * (x // y) + (x // y), y)
print(f(a, b))
