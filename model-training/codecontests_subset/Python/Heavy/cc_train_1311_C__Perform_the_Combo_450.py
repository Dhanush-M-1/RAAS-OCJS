T = int(input())
n = [0]*T
m = [0]*T
s = [0]*T
miss = [0]*T

lets = {'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}

for t in range(T):
  n[t], m[t] = [int(i) for i in input().split(' ')]
  s[t] = input()
  miss[t] = [int(i) for i in input().split(' ')]

for t in range(T):
  lets = {'a':0,'b':0,'c':0,'d':0,'e':0,'f':0,'g':0,'h':0,'i':0,'j':0,'k':0,'l':0,'m':0,'n':0,'o':0,'p':0,'q':0,'r':0,'s':0,'t':0,'u':0,'v':0,'w':0,'x':0,'y':0,'z':0}

  miss[t].sort()
  strt = 0
  for i in s[t]:
    lets[i]+=1
  for i in range(m[t]):
    for j in s[t][strt:miss[t][i]]:
      lets[j] += m[t]-i
    strt = miss[t][i]
  
  for i in lets:
    print(lets[i],end=' ')
  print()