
n = int(input())

q = ['a']
for i in range(n-1):
    nq=[]
    for j in q:
        stop=ord(max(j))+2

        for k in range(ord('a'),stop):
            nq.append(j+chr(k))
        q=nq

for i in q:
    print(i)



