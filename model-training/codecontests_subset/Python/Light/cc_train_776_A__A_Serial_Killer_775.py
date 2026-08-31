'''input
ross rachel
4
ross joey
rachel phoebe
phoebe monica
monica chandler
'''
kill,replace=list(input().strip().split(' '))
print(kill,replace)
n=int(input())
for i in range(n):
	p1,p2=list(input().strip().split(' '))
	if kill==p1:
		kill=replace
		replace=p2
	else:
		replace=kill
		kill=p2
	print(kill,replace)