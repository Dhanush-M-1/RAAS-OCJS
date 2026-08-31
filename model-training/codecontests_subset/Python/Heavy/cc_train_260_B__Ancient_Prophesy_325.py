from operator import itemgetter

def var(a):
	sim = 0

	mes = {1:31,2:28,3:31,4:30,5:31,6:30,7:31,8:31,9:30,10:31,11:30,12:31}
	dia = 0

	if a[2] >= 2013 and a[2] <= 2015:
		sim += 1

	if a[1] in mes:
		sim += 1

		dia = mes[a[1]]

	if a[0] <= dia and a[0] > 0:
		sim += 1

	return sim 


data = input()

tam = len(data)
i = 0
j = 10

datas = dict()

while j <= tam:

	a = data[i:j]

	if a[2] == a[5] and a[2] == '-':
		a = a.split('-')
		if len(a)==3:
			opa = var(list(map(int,a)))

			if opa == 3:
				aux = '-'.join(a)
				if aux in datas:
					datas[aux] += 1
				else:
					datas[aux] = 1
	i +=1
	j +=1

print(sorted(datas.items(), key=itemgetter(1))[-1][0])