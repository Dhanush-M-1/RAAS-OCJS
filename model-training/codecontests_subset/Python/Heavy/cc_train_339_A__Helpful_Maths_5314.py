"""
Exercise for strings:
print(''.join('.'+x for x in input().lower() if x not in'aeyoui'))


m, n = [int(x) for x in input().split(' ')]
print(m * n // 2)
print(eval('*'.join(input().split()))//2)

Bit++:
a = 0
sentences = int(input())
for i in range(sentences):
    if '++' in input():
        a += 1
    else:
        a -= 1
print(a)
print(sum(44-ord(input()[1])for i in[0]*int(input())))


a = input().lower()
b = input().lower()
for i in range(1):
    if a < b:
        print(-1)
    elif a > b:
        print(1)
    else:
        print(0)

i = input;
a = i().lower();
b = i().lower()
print((a > b) - (a < b))
"""

# a = []
# for i in range(5):
#     a.append(list(map(int, input().split())))
# steps = 0
# if a[2][2] == 1:
#     print(steps)
# for i in range(len(a)):
#     for j in range(len(a)):
#         b = a[i][j] + 1
#         if b == 2:
#             print(steps)
a = input()[::2]
a = [''.join(str(x)) for x in sorted([int(x) for x in a])]
a = '+'.join(a)
print(a)
