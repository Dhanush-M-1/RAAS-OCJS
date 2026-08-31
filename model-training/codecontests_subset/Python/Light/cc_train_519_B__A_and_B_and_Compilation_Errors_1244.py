N=int(input())
A=[int(x) for x in input().split()]	
B=[int(x) for x in input().split()]
C=[int(x) for x in input().split()]
X=sum(A)
Y=sum(B)
Z=sum(C)	


print(*str(X-Y),sep="")
print(*str(Y-Z),sep="")
