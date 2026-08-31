q = int(input())

for i in range(q):
	li, ri, di = input().split()
	li = int(li)
	ri = int(ri)
	di = int(di)

	minimun = li // di
	maximun = ri // di


	if ri % di == 0 or di < ri:
		maximun = (ri // di) + 1



	if di < li or di > ri:
		print(di)

	else:
		print(di * (maximun))