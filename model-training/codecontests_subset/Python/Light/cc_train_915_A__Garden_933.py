n = input().split()
k = int(n[1])
n = int(n[0])
a = list(map(int,input().split()))
a.sort()
for i in a[::-1]:
    if k%i==0:
        print(k//i)
        break
    
 