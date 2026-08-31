def main():
	from sys import stdin, stdout
	n = int(stdin.readline().rstrip())
	s = stdin.readline().rstrip()
	
	flag = True
	for i in range(n - 1):
		if s[i] <= s[i + 1]:
			continue
		else:
			stdout.write("YES\n" + str(i + 1) + " " + str(i + 2) + "\n")
			flag = False
			return
	
	if flag == True:
		stdout.write("NO\n")
		return
			
	for i in range(n):
		for j in range(n - 1, i, -1):
			#stdout.write(s[i:j] + "  " + sr + "\n")
			if s[i] > s[j]:
				#stdout.write(sr + "\n" + s[i:j] + "\n")
				stdout.write("YES\n" + str(i + 1) + " " + str(j + 1) + "\n")
				return
	
	stdout.write("NO\n")
	
if __name__ == "__main__":
	main()
