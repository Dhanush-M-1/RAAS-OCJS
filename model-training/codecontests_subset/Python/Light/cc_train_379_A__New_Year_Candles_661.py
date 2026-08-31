candels, b = [int(data) for data in input().split()]

hours = candels
candels_ends = candels

while candels_ends >= b:
    candels = candels_ends // b
    candels_ends = candels_ends - (candels * b)
    hours = hours + candels
    candels_ends = candels_ends + candels

print(hours)
