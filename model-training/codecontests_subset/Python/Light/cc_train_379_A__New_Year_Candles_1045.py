def func(START,D,REM,ANS):
	if (START<D and START+REM<D):
		return ANS
	elif (START>=D):
		while START>=D:
			REM+=(START%D)
			START//=D
			ANS+=START
		REM+=(START%D)
		return func(REM,D,0,ANS)
	else:
		START+=REM
		REM=0
		while START>=D:
			REM+=(START%D)
			START//=D
			ANS+=START
		REM+=(START%D)
		return func(REM,D,0,ANS)

C,D=map(int,input().split())
REM=C%D
START=C//D
ANS=C+START
print(func(START,D,REM,ANS))