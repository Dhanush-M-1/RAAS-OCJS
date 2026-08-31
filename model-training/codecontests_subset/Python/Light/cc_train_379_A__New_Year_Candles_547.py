#a, b = [int(x) for x in input().split()]
#total = ends = 0
#remain = a
#while remain > 0:
#    total += remain
#    ends += remain%b
#    remain = (remain-ends)//b
#print(total)


a, b = [int(x) for x in input().split()]
remain = a;total = ends = 0
while remain > 0:
    total += remain
    ends += remain
    remain = ends//b
    ends = ends%b
print(total)
