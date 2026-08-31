def f(ls1,ls2):
	while 1:
		mid=int(len(ls1)/2)
		if sum(ls1[:mid])==sum(ls2[:mid]):
			ls1=ls1[mid:len(ls1)]
			ls2=ls2[mid:len(ls2)]
		else:
			ls1=ls1[:mid]
			ls2=ls2[:mid]
		if len(ls1)==1:
			return ls1[0]
n=input()
ls1=list(map(int,input().split()))
ls2=list(map(int,input().split()))
ls3=list(map(int,input().split()))
ls4=ls2[:]
ls1.sort()
ls2.sort()
ls3.sort()
ls4.sort()
print(f(ls1,ls2))
print(f(ls4,ls3))