import collections as cl


n, s = input(), cl.Counter(input())
print(int(s['I'] == 1) if 'I' in s.keys() else s['A'])
