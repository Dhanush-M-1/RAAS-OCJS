n , k , q = map(int , input().split())
a = [0] * (n + 1)
b = list(map ( int , input().split()))
for i in range(1 , n + 1):
	a[i] = b[i - 1];
def check( l , r):
	cnt = 0;
	ln = 0;
	res = 0;
	for i in range(1 , n + 1):
		if a[i] < l:
			res += min(cnt , max(0 , ln - k + 1))
			ln = 0;
			cnt = 0;
		else :
			ln += 1;
			if a[i] <= r:
				cnt += 1;
	res += min(cnt , max(0 , ln - k + 1))
	if(res >= q):
		return True;
	return False;						

l = 0;
r = 1000000000;
res = 1000000000;
while(l <= r):
	m = (l + r) // 2;
	ok = 0;
	for i in range(1 , n + 1):
		ok |= check(a[i] - m , a[i]);
	if ok == 1:
		r = m - 1;
		res = m;
	else :
		l = m + 1;
print(res)