pwd=input()
n=int(input())
w=[]
for _ in range(n):
    w.append(input())
for i in range(n):
    for j in range(i,n):
        w1=w[i]+w[j]
        w2=w[j]+w[i]
        if w1.find(pwd)>=0 or w2.find(pwd)>=0:
            print('YES')
            exit()
print('NO')