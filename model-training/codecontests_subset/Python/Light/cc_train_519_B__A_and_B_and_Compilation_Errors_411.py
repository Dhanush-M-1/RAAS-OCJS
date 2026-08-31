def build_dict(a):
  freq = {}
  for x in a:
    freq[x] = freq.get(x, 0) + 1
  return freq

def dict_difference(d1, d2):
  for key in d1.keys():
    if key not in d2 or d1[key] != d2[key]:
      return key

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
dict_a, dict_b, dict_c = build_dict(a), build_dict(b), build_dict(c)
print(dict_difference(dict_a, dict_b))
print(dict_difference(dict_b, dict_c))