#python Solution
n, a, b, c = [sum(map(int, input().split()))for _ in ' '*4] # *4 used to unpack to 4 variables
print(a - b, b - c) # it will display the difference