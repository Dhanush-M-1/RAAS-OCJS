import sys

for bruh in range(0,int(sys.stdin.readline())):
  leng = int(sys.stdin.readline())
  vals = list(map(int,sys.stdin.readline().split()))

  if vals[0] + vals[1] > vals[leng-1]:
    sys.stdout.write("-1\n")
  else:
    sys.stdout.write("1 2 "+str(leng)+"\n")
  