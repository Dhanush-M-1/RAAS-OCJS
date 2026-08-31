n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

a = sorted(a)
b = sorted(b)
c = sorted(c)


flag = True
for i in range(n-1):
    if a[i]==b[i]:
         continue       
    else:
        flag = False
        print(a[i])
        break
if flag:
    print(a[-1])  
flaf = True  
for i in range(n-2):
    if b[i]==c[i]:
          continue
    else:
        flaf = False
        print(b[i])
        break
if flaf:
    print(b[-1])
      
