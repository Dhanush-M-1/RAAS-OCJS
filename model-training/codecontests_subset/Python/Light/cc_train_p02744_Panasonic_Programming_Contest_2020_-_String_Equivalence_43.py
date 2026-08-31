n = int(input())
s = "abcdefghij"
def func(a):
  if len(a) == n:
    print(a)
  else:
    for i in range(len(set(a))+1):
      func(a+s[i])
func("a")