n,k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
best = max(filter(lambda x: k%x==0,a))
print('%d' % (k/best))
