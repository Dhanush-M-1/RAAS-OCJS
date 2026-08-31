seg = [0]*200000

def offset(x):
	return x + 100000

def upd(node, L, R, pos, val):
	if L+1 == R:
		seg[node] += val
		seg[offset(node)] = seg[node]*L
		return
	M = (L+R)//2
	if pos < M:
		upd(node<<1, L, M, pos, val)
	else:
		upd(node<<1 | 1, M, R, pos, val)
	seg[node] = seg[node<<1] + seg[node<<1 | 1]
	seg[offset(node)] = seg[offset(node<<1)] + seg[offset(node<<1 | 1)]

def query(node, L, R, k):
	if k == 0:
		return [0, 0]
	if seg[node] < k:
		return [seg[offset(node)], seg[node]]
	if L+1 == R:
		return [L*k, k]
	M = (L+R)//2
	left = query(node<<1, L, M, k)
	right = query(node<<1 | 1, M, R, k-left[1])
	left[0] += right[0]
	left[1] += right[1]
	return left


n, m, k = map(int, input().split())
A, B, both, neither = [], [], [], []
for i in range(n):
	t, a, b = map(int, input().split())
	if a == 0 and b == 0:
		neither.append([t, i+1])
	if a == 1 and b == 0:
		A.append([t, i+1])
	if a == 0 and b == 1:
		B.append([t, i+1])
	if a == 1 and b == 1:
		both.append([t, i+1])
	upd(1, 0, 10001, t, 1)
A.sort(); B.sort(); both.sort()
p1 = min(k, len(both))
p2 = k - p1
if 2*k - p1 > m or p2 > min(len(A), len(B)):
	print(-1)
	exit(0)
sum, ans, ch = 0, 2**31, p1
for i in range(p1):
	sum += both[i][0]
	upd(1, 0, 10001, both[i][0], -1)
for i in range(p2):
	sum += A[i][0] + B[i][0]
	upd(1, 0, 10001, A[i][0], -1)
	upd(1, 0, 10001, B[i][0], -1)
ans = sum + query(1, 0, 10001, m-2*k+p1)[0]
while p1 > 0:
	if p2 == min(len(A), len(B)):
		break
	upd(1, 0, 10001, A[p2][0], -1); sum += A[p2][0]
	upd(1, 0, 10001, B[p2][0], -1); sum += B[p2][0]
	upd(1, 0, 10001, both[p1-1][0], 1); sum -= both[p1-1][0]
	p2 += 1
	p1 -= 1
	if m - 2*k + p1 < 0:
		break
	Q = query(1, 0, 10001, m-2*k+p1)
	if ans > sum + Q[0]:
		ans = sum + Q[0]
		ch = p1

print(ans)
ind = [both[i][1] for i in range(ch)] + [A[i][1] for i in range(k-ch)] + [B[i][1] for i in range(k-ch)]
st = neither + [both[i] for i in range(ch, len(both))] + [A[i] for i in range(k-ch, len(A))] + [B[i] for i in range(k-ch, len(B))]
st.sort()
ind += [st[i][1] for i in range(m-2*k+ch)]
print(' '.join([str(x) for x in ind]))