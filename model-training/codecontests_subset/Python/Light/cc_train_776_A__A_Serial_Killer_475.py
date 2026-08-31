s = input().split()
for i in range(int(input())):
	print(s[0], s[1])
	s1 = input().split()
	s[s.index(s1[0])] = s1[1]

print(s[0], s[1])
