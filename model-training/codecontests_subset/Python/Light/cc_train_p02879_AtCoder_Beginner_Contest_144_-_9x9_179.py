s = input()
a,b = map(int,s.split())

print(a*b if len(s)<4 else -1)