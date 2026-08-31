a,b,c = map(int, input().split())
print('Yes' if a+b==c or a==b+c or b==a+c else 'No')