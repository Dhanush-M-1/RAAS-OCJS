a,b = map(int,input().split())
count = a
piece=a
while piece // b >= 1:
    count += piece//b
    piece = piece//b + piece - (piece//b)*b
print(count)