import sys

for i in range(0,int(sys.stdin.readline())):
  msize=int(sys.stdin.readline())

  for j in range(0,msize):
    q=sys.stdin.readline()
    if j==0:
      a=int(q[1])
    elif j==1:
      b=int(q[0])
    if j==msize-2:
      c=int(q[msize-1])
    elif j==msize-1:
      d=int(q[msize-2])
  
  
  if a==b:
    if c==d:
      if a==c:
        sys.stdout.write("2\n")
        sys.stdout.write("1 2\n2 1\n")
      else:
        sys.stdout.write("0\n")
        pass
    else:
      sys.stdout.write("1\n")
      if a==c:
        sys.stdout.write(str(msize-1)+" "+str(msize)+"\n")
      else:
        sys.stdout.write(str(msize)+" "+str(msize-1)+"\n")
  else:
    if c==d:
      sys.stdout.write("1\n")
      if a==c:
        sys.stdout.write("1 2\n")
      else:
        sys.stdout.write("2 1\n")
    else:
      sys.stdout.write("2\n")
      sys.stdout.write("1 2\n")
      if a==c:
        sys.stdout.write(str(msize)+" "+str(msize-1)+"\n")
      else:
        sys.stdout.write(str(msize-1)+" "+str(msize)+"\n")

  