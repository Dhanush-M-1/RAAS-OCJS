s = set(input().split(' '))
n = int(input())
l = []

def ans():
    for num in s:
        l.append(num)
    print (' '.join(l))
    l.clear()
    
ans()
for i in range(n):
    s1,s2 = map(str,input().split(' '))
    s.remove(s1)
    s.add(s2)
    ans()