s1 = input()
s2 = input()
s1 = s1.split()
s2 = s2.split()
n = int(s1[0])
k = int(s1[1])
a = []
for i in s2:
    a.append(int(i))

a.sort()
t = n-1
while(t>=0):
    if k%a[t]==0:
        print(int(k/a[t]))
        break
    else:
        t-=1