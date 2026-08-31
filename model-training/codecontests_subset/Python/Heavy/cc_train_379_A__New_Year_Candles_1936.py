def Candles(a, b):
              res = a
              r = a % b
              while a > 0:
                            a = a // b
                            r = r + a % b
                            res = res + a
              a = r
              while r >= b:
                            r = a % b
                            while a > 0:
                                          a = a // b
                                          r = r + a % b
                                          res = res + a
                            a = r
                                          
                                          
              return res
a, b = input().split()
a = int(a)
b = int(b)
print(Candles(a, b))