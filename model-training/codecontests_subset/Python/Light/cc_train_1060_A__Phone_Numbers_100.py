import collections

n = int(input())
digits = input()

c = collections.Counter(digits)

print("{0}\n".format(min(len(digits) // 11, c['8'])))