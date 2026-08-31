N,K = [int(i) for i in input().split()]
Buckets = [int(i) for i in input().split()]
Buckets.sort()
Buckets.reverse()
Buckets = list(filter(lambda i: K%i==0,Buckets))
hrs = []
for i in Buckets:
    hrs.append(K//i)
print(min(hrs))