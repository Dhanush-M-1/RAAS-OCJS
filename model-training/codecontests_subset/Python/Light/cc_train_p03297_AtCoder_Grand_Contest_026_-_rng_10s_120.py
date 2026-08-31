from math import gcd
def solve():
  T = int(input())
  ans = ['No']*T
  for i in range(T):
    A,B,C,D = map(int, input().split())
    if A<B:
      continue
    now = A-(-(-(A-C)//B))*B
    if now<0:
      continue
    if D<B:
      continue
    if D%B==0:
      ans[i] = 'Yes'
      continue
    if C>=B:
      ans[i] = 'Yes'
      continue
    if B-gcd(D%B,B)>C:
      continue
    ans[i] = 'Yes'
  return ans
print(*solve(),sep='\n')