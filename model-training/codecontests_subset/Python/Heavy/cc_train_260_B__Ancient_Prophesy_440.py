s = input().split('-')

ex = {}
ans = 0
sans = ''

def solve(i):
    global ex
    global ans
    global sans
    global s
    
    day = s[i]
    month = s[i+1]
    year = s[i+2]
    
    if len(day) < 2 or len(month) != 2 or len(year) < 4:
        return
    
    day = day[-2:]
    year = year[:4]
    
    if int(year) < 2013 or int(year) > 2015:
        return
    
    if int(month) < 1 or int(month) > 12:
        return
    
    if int(day) < 1 or int(day) > 31:
        return
    
    # verifica dia de acordo com o mês (meu Deus...)
    tm = int(month)
    
    if tm in [1, 3, 5, 7, 8, 10, 12] and int(day) > 31:
        return
    
    if tm == 2 and int(day) > 28:
        return
    
    if tm in [4, 6, 9, 11] and int(day) > 30:
        return
    
    date = day+month+year
    
    if date in ex:
        ex[date] += 1
        
        if ex[date] > ans:
            ans = ex[date]
            sans = date
            
    else:
        ex[date] = 1
        
        if ans == 0:
            ans = 1
            sans = date

def c(s):
    print(f'{s[:2]}-{s[2:4]}-{s[4:]}')

for i in range(len(s)-2):
    if len(s[i]) <= 1:
        continue
    
    solve(i)
    
c(sans)