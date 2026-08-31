n,k=map(int,input().strip().split())
c = [int(i) for  i in input().split(' ')]
min_n = 1000
for i in c:
    if k%i==0:
        min_n =min(k/i,min_n)
print(int(min_n))

        

