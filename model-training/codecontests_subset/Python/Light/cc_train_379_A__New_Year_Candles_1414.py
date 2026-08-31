from sys import stdin
a, b = [int(x) for x in stdin.readline().rstrip().split()]
s,r = 0,0
while (a+r)>=b:
    s+=a
    a,r = (a+r)//b,(a+r)%b
s+=a
print(s)