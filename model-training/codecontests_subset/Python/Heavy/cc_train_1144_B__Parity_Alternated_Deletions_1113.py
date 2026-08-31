n = int(input())    #сколько чисел
mas = list(map(int,input().split()))    #заполняем
mas.sort()                              #сортируем
mas.reverse()                           #по убыванию
ch=[]   #для четных
nch=[]  #для нечетных
sum=0   #возможная сумма

for i in mas:     #идем по списку, четные значения в одну кучу, нечетные в другую      
	if i%2==0:
		ch.append(i)
	else:
		nch.append(i)

lch=len(ch)     #вычисляем размер новых списков
lnch=len(nch)   

if lch==min(lch,lnch):     #если четный короче, то суммируем из нечетного все, начиная     
	for i in range(lch+1,lnch):     #со следующего, "за общим размером" и до конца
		sum+=nch[i]
else:
	for i in range(lnch+1,lch): #а если короче нечетный - то из четного "лишние" суммируем
		sum+=ch[i]

print(sum)