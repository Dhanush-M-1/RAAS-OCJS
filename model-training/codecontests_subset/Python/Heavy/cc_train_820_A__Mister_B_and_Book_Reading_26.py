cv0v1al = input().split()
c = int(cv0v1al[0])
v0 = int(cv0v1al[1])
v1 = int(cv0v1al[2])
a = int(cv0v1al[3])
l = int(cv0v1al[4])
c_now = 0
days = 0
if v0 == 0 and a == 0:
    print(0)
elif v0 == 0 and v1 == 0:
    print(0)
elif v0 == 0 and a > v1:
    print(0)
else:
    while c_now < c:
        if days == 0 and c_now == 0:
            c_now += v0
            days += 1
        else:
            if v0 + a <= v1:
                v0 += a
            else:
                v0 = v1
            if v0 - l == 0 and a == 0 and l > 0:
                days = 0
                break
            c_now += v0 - l
            days += 1
    print(days)
"""
c,v0,v1,a,l = map(int,input().split())
cnt = 0
ans = 0
v = v0
while(cnt < c):
	cnt += v
	if(ans != 0):
		cnt -= l
	if(v + a < v1):
		v += a
	else:
		v = v1
	ans += 1
print(ans)
"""