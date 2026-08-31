"""
██╗ ██████╗ ██╗    ██████╗  ██████╗  ██╗ █████╗ 
██║██╔═══██╗██║    ╚════██╗██╔═████╗███║██╔══██╗
██║██║   ██║██║     █████╔╝██║██╔██║╚██║╚██████║
██║██║   ██║██║    ██╔═══╝ ████╔╝██║ ██║ ╚═══██║
██║╚██████╔╝██║    ███████╗╚██████╔╝ ██║ █████╔╝     
╚═╝ ╚═════╝ ╚═╝    ╚══════╝ ╚═════╝  ╚═╝ ╚════╝
"""                                        
__author__ = "Dilshod"
n = int(input())
s = input()
mx = 0
cnt = 0
ans = ""
ans1 = ""
for letters in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
	for letter in "ABCDEFGHIJKLMNOPQRSTUVWXYZ":
		for i in range(n - 1):
			if s[i] == letters and s[i + 1] == letter:
				ans1 = s[i] + s[i + 1]
				cnt += 1
		if mx <= cnt:
			ans = ans1
			ans1 = ""
			mx = cnt
		else:
			ans1 = ""
		cnt = 0
print(ans)
