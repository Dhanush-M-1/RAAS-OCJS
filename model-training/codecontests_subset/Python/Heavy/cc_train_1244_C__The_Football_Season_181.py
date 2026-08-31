def gcd(a, b, x, y):
  if(b == 0):
    x = 1
    y = 0
    return (a, x, y)

  d, x1, y1 = gcd(b, a % b, x, y)
  x = y1
  y = x1 - y1*(a // b)

  return (d, x, y)

def find_any_solution(a, b, c, x0, y0, g):
  g, x0, y0 = gcd(a, b, x0, y0)
  if c % g == 1:
      return (-1, x0, y0)

  x0 *= (c//g)
  y0 *= (c//g)
  
  if a < 0:
      x0 = -x0
  if b < 0:
      y0 = -y0;

  return (g, x0, y0)

def main():
  entrada = input("")
  entrada = entrada.split(' ')
  n, p, w, d = entrada
  n = int(n)
  p = int(p)
  w = int(w)
  d = int(d)


  x = None
  y = None
  g = None

  g, x, y = find_any_solution(w, d, p, x, y, g)

  if g == -1:
      print(-1)
      return 0
  w //= g
  d //= g

  if(y < 0):
      k = abs(y//w);

      y += k*w
      x -= k*d

      if y < 0:
          y += w
          x -= d


  if(x < 0):
      k = abs(x//d);

      y -= k*w;
      x += k*d;

      if(x < 0):
          y -= w;
          x += d;
      
  


  if(y > 0):
      k = abs(y//w);

      y -= k*w;
      x += k*d;
  

  

  N = n - x - y;


  if(x < 0 or y < 0 or (n - x - y < 0)):
    print(-1)
  else :
    print("%d %d %d" %(x, y,N))  


main()

