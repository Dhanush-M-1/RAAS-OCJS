__author__ = 'sanu001'
import queue

__read_tokens = queue.Queue()


def next_string():
  while __read_tokens.empty():
    for i in input().split():
      __read_tokens.put(i)
  return __read_tokens.get()


def next_int():
  return int(next_string())


def next_float():
  return float(next_string())


def next_line():
  if not __read_tokens.empty():
    raise Exception("Unclean token cache")
  return input()

s = next_string()
ss = s.split('+')
a = []
for i in ss:
    a.append(int(i))
a = sorted(a)

ss = ''
for i in a:
    ss += str(i) + '+'
print(ss[:-1])
