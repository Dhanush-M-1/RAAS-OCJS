a, b = (int(i) for i in input().split())
print("Odd" if (a*b)&1 else "Even")