from collections import Counter
input()
s =Counter(input())
print([0,1][s['I'] == 1] if 'I' in s.keys() else s['A'])