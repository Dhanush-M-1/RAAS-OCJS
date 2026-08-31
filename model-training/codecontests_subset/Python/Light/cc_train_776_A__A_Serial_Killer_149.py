st=input().split()
n=int(input())
l=[st]
e=st
for i in range(n):
    o=input().split()
    e=set(e)-{o[0]}
    e.add(o[1])
    l.append(list(e))
for i in l:
    print(' '.join(i))
