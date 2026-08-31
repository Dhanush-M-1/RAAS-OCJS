a = input()
b= list(input().split())
B=[int(x) for x in b]

c= list(input().split())
C=[int(x) for x in c]

d= list(input().split())
D=[int(x) for x in d]

print(sum(B)-sum(C))
print(sum(C)-sum(D))

