a,b = [int(x) for x in input().split()]
l1 = [0]*1000
l2 = [0]*1000
l1[0] = a
for i in range(999):
    l1[i+1] = (l2[i] + l1[i])//b
    l2[i+1] = (l2[i] + l1[i])%b
print(sum(l1))