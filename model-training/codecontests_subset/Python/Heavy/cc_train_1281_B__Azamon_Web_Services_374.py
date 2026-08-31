import collections

T = int(input())

for _ in range(T):
  s1, s2 = input().split()
  if len(set(s1)) > 1:
    arr = list(s1)
    cnt = collections.Counter(arr)
    i = 0
    while i < len(arr) and arr[i] == min(cnt.keys()):
      cnt[arr[i]] -= 1
      if cnt[arr[i]] == 0:
        del cnt[arr[i]]
      i += 1
    i2 = i
    if len(cnt.keys()) != 0:
      lo = min(cnt.keys())
      while i2 < len(arr):
        if arr[i2] == lo:
          i3 = i2
        i2 += 1
      arr[i], arr[i3] = arr[i3], arr[i]
      ans = ''.join(arr)
    else:
      ans = s1
  else:
    ans = s1
  if ans < s2:
    print(ans)
  else:
    print('---')
