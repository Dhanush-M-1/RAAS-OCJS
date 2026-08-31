n, x, y = map(int, input().split())
need = round(n * y / 100) + (((n*y/100) > (n*y//100) and  round((n*y)/100) < (n*y//100)+1  ))
print(max(need - x, 0))
