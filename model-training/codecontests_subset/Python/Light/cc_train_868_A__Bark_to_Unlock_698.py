from sys import stdin, stdout
 
f = stdin.readline().strip()
n = int(stdin.readline())
challengers = []

for i in range(n):
    challengers.append(stdin.readline().strip())

label = 0
for i in range(n):
    for j in range(n):
        s = challengers[i] + challengers[j]
        
        if f in s:
            label = 1

if label:
    stdout.write('YES')
else:
    stdout.write('NO')