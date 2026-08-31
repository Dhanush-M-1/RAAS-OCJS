#設定
import sys
input = sys.stdin.buffer.readline

#ライブラリインポート
from collections import defaultdict
import bisect

#入力受け取り
def getlist():
	return list(map(int, input().split()))

#処理内容
def main():
	Q = int(input())
	for i in range(Q):
		N = int(input())
		A = getlist()
		B = [0]
		v = A[0]
		c = 0
		for j in range(N):
			if A[j] == v:
				c += 1
			else:
				B.append(c)
				c += 1
			v = A[j]
		B.append(c)

		# print(B)
		g = B[1]
		s = 0
		b = 0
		x = bisect.bisect_left(B, int(N // 2))
		if B[x] > int(N // 2):
			x -= 1
		# print(B[x])
		total = B[x]

		judge = "No"
		for j in range(2, x + 1):
			X = B[j]
			if X > 2 * g and total - X > g:
				s = X - g
				b = total - X
				judge = "Yes"
				break

		if judge == "No":
			print(0, 0, 0)
		else:
			print(g, s, b)

if __name__ == '__main__':
	main()