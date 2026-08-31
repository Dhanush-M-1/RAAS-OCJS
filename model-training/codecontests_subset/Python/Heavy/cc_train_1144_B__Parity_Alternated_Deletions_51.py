from collections import Counter
n = int(input())
a = sorted(list(map(int, input().split())))[::-1]
even = []
odd = []
for i in a:
    if i % 2 == 0: even.append(i)
    else: (odd.append(i))
turn = 0
z = len(even) > len(odd)
z1 = len(even) == len(odd)
if(z):
    even.remove(even[0])
    turn = 1
else:
    odd.remove(odd[0])
if(z1):
    if(odd[0] > even[0]): odd.remove(odd[0])
    else: even.remove(even[0])
s = [even, odd]
while len(s[turn]) != 0:
    s[turn].remove(s[turn][0])
    turn = (turn+1)%2
print(sum(s[0])+sum(s[1]))