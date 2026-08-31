S = input().split()
N = int(input())
for i in range(N):
    print(" ".join(S))
    s1, s2 = input().split()
    if s1 == S[0]:
        S[0] = s2
    elif s1 == S[1]:
        S[1] = s2
print(" ".join(S))
