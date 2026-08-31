a='a'
for _ in range(int(input())-1):
  a=[s+c for s in a for c in sorted(set(s+chr(ord(max(s))+1)))]
print(*a,sep='\n')