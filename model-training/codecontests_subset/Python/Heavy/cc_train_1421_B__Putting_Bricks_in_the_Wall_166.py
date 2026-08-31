# import sys; input = sys.stdin.buffer.readline
# sys.setrecursionlimit(10**7)
from collections import defaultdict
mod = 10 ** 9 + 7; INF = float("inf")

def getlist():
	return list(map(int, input().split()))

def main():
	T = int(input())
	for _ in range(T):
		N = int(input())
		L = []
		for i in range(N):
			l = list(input())
			L.append(l)

		a1 = int(L[0][1])
		a2 = int(L[1][0])
		a3 = int(L[-2][-1])
		a4 = int(L[-1][-2])
		ans1 = []
		cnt1 = 0
		if a1 != 0:
			ans1.append([1, 2])
			cnt1 += 1
		if a2 != 0:
			ans1.append([2, 1])
			cnt1 += 1
		if a3 != 1:
			ans1.append([N - 1, N])
			cnt1 += 1
		if a4 != 1:
			ans1.append([N, N - 1])
			cnt1 += 1

		ans2 = []
		cnt2 = 0
		if a1 != 1:
			ans2.append([1, 2])
			cnt2 += 1
		if a2 != 1:
			ans2.append([2, 1])
			cnt2 += 1
		if a3 != 0:
			ans2.append([N - 1, N])
			cnt2 += 1
		if a4 != 0:
			ans2.append([N, N - 1])
			cnt2 += 1

		if cnt1 <= cnt2:
			print(cnt1)
			for i in range(len(ans1)):
				print(*ans1[i])
		else:
			print(cnt2)
			for i in range(len(ans2)):
				print(*ans2[i])


if __name__ == '__main__':
	main()