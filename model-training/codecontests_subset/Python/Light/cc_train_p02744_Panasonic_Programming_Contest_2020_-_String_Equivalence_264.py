N = int(input())
def sub(l, d):
  if d == N:
    s = "".join(["abcdefghijklmnopqrstuvwxyz"[i] for i in l])
    print(s)
    return
  for j in range(max(l)+1+1):
    sub(l+[j], d+1)
sub([0], 1)
