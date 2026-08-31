Set = [("lu", "ru"), ("ru","lu"), ("ld","rd"), ("rd","ld")]

while True :
	n = int(input())
	if(n == 0) :
		break
	else :
		F = list(map(str, input().split()))
		cnt = 0
		while(len(F) > 1) :
			if((F[0], F[1]) in Set) :
				cnt += 1
				del F[0 : 2]
			else :
				del F[0]
		print(cnt)
