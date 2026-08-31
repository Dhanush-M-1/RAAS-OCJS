n = int(input().strip())
printing = []
for test in range(n):
      m = input()
      a = input().strip().split(" ")
      b= []
      for c in a:
            b.append(int(c))
      b.sort()
      if int(b[0]) + int(b[1]) <= int(b[-1]):
            d = []
            d.append(a.index(str(b[0]))+1)
            d.append(a.index(str(b[1]))+1)
            count = 0
            while d[1] == d[0]:
                  a[int(d[0])-1]=-1
                  d[1] = a.index(str(b[1]))+1
            d.append(a.index(str(b[-1]))+1)
            d.sort()
            printing.append(" ".join(map(str,d)))
      else:
            printing.append("-1")
for item in printing:
      print(item)
