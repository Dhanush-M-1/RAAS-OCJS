# AOJ 0127 Pocket Pager Input
# Python3 2018.6.18 bal4u

a = ['']*100

a[11], a[12], a[13], a[14], a[15] = 'a', 'b', 'c', 'd', 'e'
a[21], a[22], a[23], a[24], a[25] = 'f', 'g', 'h', 'i', 'j'
a[31], a[32], a[33], a[34], a[35] = 'k', 'l', 'm', 'n', 'o'
a[41], a[42], a[43], a[44], a[45] = 'p', 'q', 'r', 's', 't'
a[51], a[52], a[53], a[54], a[55] = 'u', 'v', 'w', 'x', 'y'
a[61], a[62], a[63], a[64], a[65] = 'z', '.', '?', '!', ' '

while True:
	try: buf = list(input())
	except: break
	
	f = True
	ans = ''
	for i in range(0, len(buf), 2):
		if i+1 >= len(buf):
			f = False
			break
		if buf[i].isdigit() and buf[i+1].isdigit():
			k = int(buf[i]+buf[i+1])
			if a[k] != '': ans += a[k]
			else:
				f = False
				break
	print(ans if f else "NA")
