# @Date    : 2019-05-25 18:31:17
# @Author  : Pranav Ballaney (ballaneypranav@gmail.com)

# http://codeforces.com/problemset/problem/268/A

n = int(input())
host_counts = {}
guest_counts = {}

for i in range(n):
	h, g = map(int, input().split())

	if h in host_counts:
		host_counts[h] = host_counts[h] + 1
	else:
		host_counts[h] = 1

	if g in guest_counts:
		guest_counts[g] = guest_counts[g] + 1
	else:
		guest_counts[g] = 1
	
result = 0

for i in range(1, 101):
	if i in host_counts and i in guest_counts:
		result = result + host_counts[i] * guest_counts[i]

print(result)