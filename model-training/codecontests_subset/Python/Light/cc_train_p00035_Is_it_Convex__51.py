import sys
for e in sys.stdin:
 e=list(map(float,e.split(',')))
 print(['YES','NO'][sum((e[i]-e[(2+i)%8])*(e[(5+i)%8]-e[(3+i)%8])-(e[1+i]-e[(3+i)%8])*(e[(4+i)%8]-e[(2+i)%8])>0 for i in range(0,8,2))%4>0])
