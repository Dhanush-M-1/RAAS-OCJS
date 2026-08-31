def TwoGram(n, s):
              count = 0
              res = {}
              for i in range(n - 1):
                            res[s[i:i + 2]] = 1
              for i in range(n - 1):
                            if s[i:i + 2] in s[i + 1:n]:
                                          res[s[i:i + 2]] = res[s[i:i + 2]] + 1
              m = max(res.values())
              #print(m)
              for i in range(n  - 1):
                            if res[s[i:i + 2]] == m:
                                          return s[i : i + 2]
x = int(input())
x1 = input()
print(TwoGram(x, x1))