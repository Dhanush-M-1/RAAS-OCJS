# from sys import stdin, stdout

# alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

# t = int(input())
# a, b, c = map(int, stdin.readline().split())
# tab = list(map(int, stdin.readline().split()))

# for _ in range(t):
	# s = input()
	# k = int(input())
	# arr = list(map(int, input().split()))
	
	# for val in arr:
		# stdout.write(str(val) + " ")
	# print()
n = int(input())
s = input()
if(''.join(sorted(s)) == s):
	print("NO")
else:
	print("YES")
	for i in range(n - 1):
		if ord(s[i]) > ord(s[i+1]):
			print(i + 1, i + 2)
			exit()
				