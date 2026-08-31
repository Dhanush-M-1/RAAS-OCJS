N=int(input())
L=['a','b','c','d','e','f','g','h','i','j']

Ans = [L[0]]
Backup = []

for k in range(N-1):
    Backup = Ans
    Ans = [i+L[j] for i in Backup for j in range(len(set(i))+1)]

for i in Ans:
    print(i)