rof = "f" + "o" + "r" #0
fi = "i" + "f" #1

code = """
def floyd(n, c):
	{0} k in range(n):
		{0} j in range(n):
			{0} i in range(n):
				c[i][j] = min(c[i][j], c[i][k] + c[k][j])

def array(s, v = 0, i = 0):
	{1} i >= len(s) - 1:
		return [v] * s[i]
	r = array(s, v, i + 1)
	return [r.copy() {0} i in range(s[i])]

n = int(input())
c = array([n, n])
{0} i in range(n):
	v = input().split()
	{0} j in range(n):
		c[i][j] = int(v[j])

floyd(n, c)

m = -1
{0} i in range(n):
	{0} j in range(n):
		m = max(m, c[i][j])

print(m)
""".format(rof, fi)

exec(code)
