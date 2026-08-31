from string import ascii_uppercase

for _ in range(int(input())):
	s, c = input().split()
	if s<c:
		print(s)
		continue

	cnt = dict()
	for i in s:
		try:
			cnt[i] += 1
		except:
			cnt[i] = 1
	sorted_s = ""
	for char in ascii_uppercase:
		try:
			sorted_s += char*cnt[char]
		except:
			pass
	obtained_new_s = False
	for i in range(len(s)):
		if s[i]>sorted_s[i]:
			pos = -1
			for j in range(len(s)):
				if(sorted_s[i]==s[j]):
					pos = j

			new_string = s[:i] + s[pos] + s[min(i+1, len(s)):min(pos, len(s))] + s[i] + s[min(pos+1, len(s)):]
			obtained_new_s = True
			break
	if not obtained_new_s:
		new_string = s
	if new_string<c:
		print(new_string)
	else:
		print('---')