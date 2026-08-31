n = int(input())
A = set(map(int,input().strip().split(' ')))
s = 1
e = 10**6
t = -1
while(len(A) > 0):
    if(s in A):
        A.remove(s)
    if(e in A):
        A.remove(e)
    s+=1
    e-=1
    t+=1
print(t)

