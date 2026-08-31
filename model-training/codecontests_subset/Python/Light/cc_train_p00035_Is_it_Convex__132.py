import sys
for e in sys.stdin:
 e=list(map(float,e.split(',')));n=0
 for i in range(0,8,2):
  if(e[i]-e[(2+i)%8])*(e[(5+i)%8]-e[(3+i)%8])-(e[1+i]-e[(3+i)%8])*(e[(4+i)%8]-e[(2+i)%8])>0:n+=1
 print(['YES','NO'][n%4>0])
