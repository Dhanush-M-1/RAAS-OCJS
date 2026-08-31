from collections import Counter
def compilation(s, s1):
                c = Counter(s)
                c1 = Counter(s1)
                for i in range(len(s)):
                                if c[s[i]] != c1[s[i]]:
                                                return s[i]
                                
n = int(input())
s = [int(n) for n in input().split()]
s1 = [int(n) for n in input().split()]
s2 = [int(n) for n in input().split()]
print(compilation(s, s1))
print(compilation(s1, s2))