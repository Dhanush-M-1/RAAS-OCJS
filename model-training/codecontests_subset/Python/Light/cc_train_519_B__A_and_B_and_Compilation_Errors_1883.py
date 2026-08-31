input()
a = sorted(map(int,input().split()))
b = sorted(map(int,input().split()))
c = sorted(map(int,input().split()))
x = False
for i in range(len(b)):
     if a[i] != b[i]:
          print(a[i])
          x = True
          break
if x == False:
     print(a[len(a)-1])
x = False
for i in range(len(c)):
     if c[i] != b[i]:
          print(b[i])
          x = True
          break
if x == False:
     print(b[len(b)-1])