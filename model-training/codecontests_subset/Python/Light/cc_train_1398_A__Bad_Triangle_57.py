def main():
	for _ in range(int(input())):
		s = int(input())
		l = [int(i) for i in input().split()]
		if l[0] + l[1] > l[-1]:
			print(-1)
		else:
			print(1,2, s)
main()
#