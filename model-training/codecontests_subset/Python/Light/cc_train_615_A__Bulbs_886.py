n,m = list(map(int, input().split()))
st = set()
for _ in range(n):
	for n in list(map(int, input().split()))[1:]:
		st.add(n)
		
if len(st) == m:
	print("YES")
else:
	print("NO")