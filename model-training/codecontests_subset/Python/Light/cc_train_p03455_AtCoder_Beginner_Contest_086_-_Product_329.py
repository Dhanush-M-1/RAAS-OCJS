A, B = map(int, input().split())
print(["Odd", "Even"][not(A * B % 2)])
