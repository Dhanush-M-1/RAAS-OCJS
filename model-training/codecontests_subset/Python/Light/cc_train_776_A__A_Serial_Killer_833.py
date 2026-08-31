pair = set(input().split())
n = int(input())
for name in pair:
    print(name, end = ' ')
print('')
for i in range(n):
    a,b = map(str,input().split())
    pair.remove(a)
    pair.add(b)
    for name in pair:
        print(name, end = ' ')
    print('')