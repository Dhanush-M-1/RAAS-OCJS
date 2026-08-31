n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
sumA = 0
sumB = 0
sumC= 0
for i in a:
    sumA += i
for i in b:
    sumB += i
for i in c:
    sumC += i
print(sumA-sumB,sumB-sumC,sep='\n')