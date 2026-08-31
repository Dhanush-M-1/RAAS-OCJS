n=int(input())
reading=list(map(int,input().split()))
massimo=0
for a in range(n):
	premio = reading[a]
	tempo = min(premio - 1, 1000000-premio)
	if (tempo>massimo):
		massimo = tempo
print(massimo)
