q=int(input())
for i in range(q):
      l, r, d=input().split()
      if int(d)<int(l):
            print(d)
      else:
            print(((int(r)//int(d))+1)*int(d))