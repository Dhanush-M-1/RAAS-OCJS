n = int(input())
A = ['a']
S = 'abcdefghij'
for _ in range(n-1):
    B = []
    for a in A:
        for s in S[:len(set(a)) + 1]:
            B.append(a + s)
    A = B[::]
print('\n'.join(A))