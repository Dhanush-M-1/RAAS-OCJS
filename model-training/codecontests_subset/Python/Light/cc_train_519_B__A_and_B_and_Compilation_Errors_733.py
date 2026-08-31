n = int(input())
a1 = input().split(" ")
a = [int(i) for i in a1]
a.sort()
b1 = input().split(" ")
b = [int(i) for i in b1]
b.sort()
c1 = input().split(" ")
c = [int(i) for i in c1]
c.sort()

s1=sum(a)
s2=sum(b)
s3=sum(c)
print(s1-s2)
print(s2-s3)