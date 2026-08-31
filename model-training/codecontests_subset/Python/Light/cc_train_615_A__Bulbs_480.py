#import sys
#sys.stdin = open("input.in","r")
#sys.stdout = open("test.out","w")
a,b= map(int, input().split())
s= set()
for i in range(a):
    c= input().split()
    for j in range(int(c[0])):
        s.add(int(c[j + 1]))
if len(s)==b:
	print("YES")
else:
	print("NO")
 