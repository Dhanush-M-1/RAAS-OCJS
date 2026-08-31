ab = input().split(" ")
for i in range(len(ab)):
    ab[i] = int(ab[i])
a = ab[0]
b = ab[1]
counter = a
while a>0:
    a = a-b+1
    counter += 1
counter -= 1
print(counter)