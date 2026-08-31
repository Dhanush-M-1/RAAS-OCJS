a,b=input().split()
print(a,b)
for _ in range(int(input())):
         x,y=input().split()
         if(x==a):
                  a=y
         else:
                  b=y
         print(a,b)