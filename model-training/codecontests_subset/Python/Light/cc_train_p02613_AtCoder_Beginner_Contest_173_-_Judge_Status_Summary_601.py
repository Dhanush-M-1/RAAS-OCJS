n= int(input())

tab= {'AC':0, 'WA':0, 'TLE':0, 'RE':0}

for i in range(n):
	tab[input()]+=1

for i in tab:
	print( i, 'x', tab[i])