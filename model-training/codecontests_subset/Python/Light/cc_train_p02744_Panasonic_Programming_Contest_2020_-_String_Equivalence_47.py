n = int(input())
A= 'a'
# 文字数を増やして, その各々の元に対して文字を追加する.
for _ in range(n - 1):
    A = {a + s for a in A for s in a + chr(ord(max(a)) + 1)}
    # print(A)
# 最後にsortして調整する.
#print(*A, sep = '\n')
print(*sorted(A), sep='\n')