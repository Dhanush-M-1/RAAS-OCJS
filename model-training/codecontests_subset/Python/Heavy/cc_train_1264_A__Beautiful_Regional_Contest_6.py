import math

def count(l, x):
	r = 0
	for i in l:
		if i > x:
			continue
		if x == i:
			r += 1
		else:
			break
	return r
	
def count2(l, a, b):
	r = 0
	for i in l:
		if i >= b:
			continue
		elif i < b and i >= a:
			r += 1
		else:
			break
	return r
	
def fast_del(l):
	x = l[-1]
	delind = 1
	for i in range(2, len(l)+1):
		if l[-i] == x:
			delind += 1
		else:
			break
	return delind

T = int(input())
result = ""

for t in range(T):
	
	n = int(input())
	text = list(map(int, input().split(' ')))
	
	if len(text) > 1:
		r = math.floor(n/2)
		students = text[:r]
		if text[r] == students[r-1]:
			d = fast_del(students)
			students = students[:-d]
	else:
		students = text
	
	if not students:
		result += "0 0 0\n"
		continue
	gold = students[0]
	servial = -1
	bronze = -1
	
	g = count(students, gold)
	s = 0
	b = 0
	
	bronze = students[-1]
	for i in range(len(students)-1, 0, -1):
		if students[i] == bronze:
			b += 1
		else:
			if b <= g:
				bronze = students[i]
				b += 1
				continue
			servial = students[i]
			break
			
	if servial == -1:
		result += "0 0 0\n"
		continue
	
	if b <= g:
		result += "0 0 0\n"
		continue
				
	
	s = count2(students, servial, gold)
	
	
	if s <= g:
		result += "0 0 0\n"
		continue
		
	if s == 0 and b == 0:
		g = 0
	
	result += str(g) + ' ' + str(s) + ' ' + str(b) + '\n'

print(result)