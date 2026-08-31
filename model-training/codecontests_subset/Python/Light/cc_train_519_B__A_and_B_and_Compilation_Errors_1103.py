n=int(input())
a=[int(w) for w in input().split()]
b1 = sum(a)
a=[int(w) for w in input().split()]
b2 = sum(a)
b1-=b2
a=[int(w) for w in input().split()]
b2-=sum(a)

print(b1)
print(b2)


