I=lambda:list(map(int, input().split()))
n,m=I()
s=set()
for _ in range(n):
    for i in I()[1:]:
        s.add(i)
print("YNEOS"[m!=len(s)::2])