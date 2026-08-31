from sys import stdin,stdout
import bisect
n=int(stdin.readline())
for i in range(n):
    ans=0
    a=int(stdin.readline())
    x=[int(i) for i in stdin.readline().split()]
    x.sort()
    if x[0]+x[1]>x[-1]:
        stdout.write('-1'+'\n')
        continue
    stdout.write(str(1)+' '+str(2)+' '+str(len(x))+'\n')
