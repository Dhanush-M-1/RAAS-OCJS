a,b = [int(x) for x in input().split()]
count = a
res = a
while res >= b:
	count += res//b
	res = res//b + res%b
print (count)