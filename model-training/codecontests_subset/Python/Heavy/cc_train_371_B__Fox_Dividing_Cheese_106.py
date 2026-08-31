import sys
sys.setrecursionlimit(100000)
n, m = [int(x) for x in sys.stdin.readline().strip().split()]
def factors(n):
	d = {2:0,3:0,5:0}
	arr = [2,3,5]
	for i in arr:
		s = n
		while s:
			if s%i==0:
				d[i]+=1
			s = s/i
	return d
n_fac = factors(n)
m_fac = factors(m)
comm_fac = {2:min(n_fac[2],m_fac[2]),3:min(n_fac[3],m_fac[3]),5:min(n_fac[5],m_fac[5])}
nd = (2**(n_fac[2]-comm_fac[2]))*(3**(n_fac[3]-comm_fac[3]))*(5**(n_fac[5]-comm_fac[5]))
md = (2**(m_fac[2]-comm_fac[2]))*(3**(m_fac[3]-comm_fac[3]))*(5**(m_fac[5]-comm_fac[5]))
if n/nd==m/md:

	nc = n_fac[2]+n_fac[3]+n_fac[5]
	mc = m_fac[2]+m_fac[3]+m_fac[5]
	cc = comm_fac[2]+comm_fac[3]+comm_fac[5]
	c = 2*cc-nc-mc
	print(-c)
else:
	print(-1)
