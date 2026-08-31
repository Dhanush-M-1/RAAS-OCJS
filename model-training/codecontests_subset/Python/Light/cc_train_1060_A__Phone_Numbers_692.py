n=int(input())
x=input()
k=0
m=0
z=0
for i in x:
    if int(i)==8:
        k+=1

for i in range(k):
    m+=11
    if n<m:
        break
    z+=1
print(z)
    