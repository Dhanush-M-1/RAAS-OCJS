n=int(input())-1
a='a'
for _ in range(n):
    a=set([s+ c for s in a for c in s+chr(ord(max(s))+1)])
print(*sorted(a),sep='\n')