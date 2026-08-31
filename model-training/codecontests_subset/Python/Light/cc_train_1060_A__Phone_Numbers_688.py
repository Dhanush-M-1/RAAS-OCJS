length =int(input())
line = str(input())
len11 = int(length/11)
print(min(len11, line.count("8")))