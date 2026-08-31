A = 'a'
S = 'abcdefghij'
for _ in range(int(input())-1):
    A = [a + s for a in A for s in S[:len(set(a)) + 1]]
print('\n'.join(A))