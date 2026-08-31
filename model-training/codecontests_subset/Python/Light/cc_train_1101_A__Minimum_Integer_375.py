

q = int(input())



for i in range(q):
 l,r,d = map(int,input().split())
 if l<=d<=r:
    m = r//d
    print(d*(m+1))




 elif d<l:
    print(d)
 elif d>r:
    print(d)




