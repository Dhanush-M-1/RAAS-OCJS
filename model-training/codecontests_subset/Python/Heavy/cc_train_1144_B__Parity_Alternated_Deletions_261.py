n = int(input())
a = [int(i) for i in input().split()]
eve = []
odd = []
s = 0
a = sorted(a, reverse = True)
for i in a:
    if i%2 == 0:
       eve.append(i)
    else:
        odd.append(i)
if len(eve) == len(odd):
    print(0)
elif min(len(eve),len(odd))+1 == max(len(eve),len(odd)):
    print(0)
else:
    no = min(len(eve),len(odd))+1
    odd = odd[::-1]
    eve = eve[::-1]
    if len(odd) > len(eve):
        while(no > 0):
            odd.pop()
            no -= 1
        print(sum(odd))
    else:
        while(no > 0):
            eve.pop()
            no -= 1
        print(sum(eve))
