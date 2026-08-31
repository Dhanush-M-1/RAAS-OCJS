a, b = map(int, input().split())
output = b*((a-b)//(b-1)+1) + (a-b) % (b-1) + 1
print(output)
