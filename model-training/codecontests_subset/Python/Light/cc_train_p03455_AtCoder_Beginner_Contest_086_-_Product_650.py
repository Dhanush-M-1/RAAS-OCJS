A,B = (int(X) for X in input().split())
print(['Odd','Even'][(A*B)%2==0])