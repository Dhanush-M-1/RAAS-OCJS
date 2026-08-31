from collections import deque

def dfs(s, al, nw, used):
	nw[s] = 0
	q = deque([s])
	used.add(s)
	while q:
		h = q.popleft()
		for to, ew in al[h]:
			if to in used:
				if nw[h] + ew != nw[to]:
					return False
				continue
			used.add(to)
			nw[to] = nw[h] + ew
			q.appendleft(to)
	return True

def main():
	N, M = map(int, input().split())
	nw = [-1] * N
	al = [[] for i in range(N)]
	for i in range(M):
		l, r, d = map(int, input().split())
		al[l - 1].append((r - 1, d))
		al[r - 1].append((l - 1, -d))

	used = set()
	for i in range(N):
		if i in used or dfs(i, al, nw, used):
			continue
		print("No")
		break
	else:
		print("Yes")


if __name__ == "__main__":
	main()
