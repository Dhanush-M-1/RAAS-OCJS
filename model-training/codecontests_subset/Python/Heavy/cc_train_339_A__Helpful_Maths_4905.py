summans=input()
ones=summans.count("1")
twos=summans.count("2")
threes=summans.count("3")
if len(summans)>1:
	if ones>0:
		for i in range(1,ones+1):
			print("1+" if i<ones else "1",end="")
	if twos>0:
		print("+" if ones>0 else "",end="")
		for i in range(1,twos+1):
			print("2+" if i<twos else "2",end="")
	if threes>0:
		print("+" if twos>0 else "",end="")
		print("+" if twos==0 and ones>0 else "",end="")
		for i in range(1,threes+1):
			print("3+" if i<threes else "3",end="")
else:
	print(summans)
