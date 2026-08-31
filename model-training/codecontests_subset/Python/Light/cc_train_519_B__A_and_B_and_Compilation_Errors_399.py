n = int(input())
a = input()
b = input()
c = input()

x = a.split()
x1 = b.split()
x2 = c.split()

x.sort()
x1.sort()
x2.sort()


res = list()

for i in range(n):
    if(i>=len(x1) or x[i] != x1[i]):
        x1.insert(i,'@')
    if(i>=len(x2) or x[i] != x2[i]):
        x2.insert(i,'@')
t = 0
for i in range(n):
    if x1[i] == '@' and len(res)<2:
        res.append(int(x[i]))
        t = i
for i in range(n):
    if x2[i] == '@' and len(res)<2 and i!=t:
        res.append(int(x[i]))        
print(res[0])
print(res[1])