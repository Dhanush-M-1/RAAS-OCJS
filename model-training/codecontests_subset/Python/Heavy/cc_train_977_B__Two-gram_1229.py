import sys
input = sys.stdin.readline
l = int(input())
s = str(input())
occurenece = dict()
for i in range(0,len(s)-2):
  if not occurenece.__contains__(f'{s[i]}{s[i+1]}'):
    occurenece[f'{s[i]}{s[i+1]}'] = 1
  else:
    occurenece[f'{s[i]}{s[i+1]}'] = occurenece[f'{s[i]}{s[i+1]}'] + 1
max_value = 0
max_index = 0
values = list(occurenece.values())
keys = list(occurenece.keys())
for i in range(len(values)):
  if values[i]>max_value:
    max_value = values[i]
    max_index = i
print(keys[max_index])
  