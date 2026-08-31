n,k=input().split()
count=int(n)
while int(n)>=int(k):
    count=count+int(n)//int(k)
    n=int(n)//int(k)+int(n)%int(k)
print(count)
