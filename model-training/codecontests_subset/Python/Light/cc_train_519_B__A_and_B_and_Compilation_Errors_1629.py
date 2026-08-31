n = input()
l1 = input()
l1 = l1.split()
l2 = input()
l2 = l2.split()
l3 = input()
l3 = l3.split()



x1 = int(l1[0])
#print(x1)
for i in l1[1:]:
    #print(i)
    #print(x1)
    x1 = x1 ^ int(i)

x2 = int(l2[0])
for i in l2[1:]:
    x2 = x2 ^ int(i)


x3 = int(l3[0])
for i in l3[1:]:
    x3 = x3 ^ int(i)

print(x1^x2)
print(x2^x3)
