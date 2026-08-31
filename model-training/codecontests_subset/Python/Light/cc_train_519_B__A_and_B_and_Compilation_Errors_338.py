input()
a,b,c=[sum(int(i) for i in input().split()) for _ in range(3)]
print(a-b)
print(b-c)