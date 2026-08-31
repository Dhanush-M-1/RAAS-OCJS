n = int(input().strip())
s = input().strip()

toprint = ""

def calc(s, sp):
	global toprint
	if(s=="" and sp==""):
		return 0
	elif(s==""):
		return calc(sp, "")
	elif(sp==""):
		if(s.count('0')==len(s)/2.):
			return calc(s[:-1], s[-1])
		else:
			toprint += " "+s
			return 1
	if(s.count('0')!=len(s)/2. and sp.count('0')!=len(sp)/2.):
		toprint += " "+s+" "+sp
		return 2
	elif(sp.count('0')!=len(sp)/2.):
		a = calc(s[:-1], s[-1]+sp)
		b = 1+calc(s, "")
		if(b<a):
			toprint += " "+sp
		return min(a,b)
	elif(s.count('0')!=len(s)/2.):
		a = calc(s[:-1], s[-1]+sp)
		b = 1+calc(sp, "")
		if(b<a):
			toprint += " "+s
		return min(a,b)
	else:
		return calc(s[:-1], s[-1]+sp)


if(s.count('0')!=n/2.):
	print(str(1)+"")
	print(s)
else:
	print(calc(s, ""))
	print(toprint.strip())
