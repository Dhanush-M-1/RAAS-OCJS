n_buckets, garden_length = map(int, input().strip().split())

#print(n_buckets, garden_length)

# idea: abstract garden into a line of length K
# abstract each bucket as segment of length Li
# Segment must be divisor of K, otherwise will overlap or go out of bounds
# Hours taken = K / Li, meaning one will chose the largest divisor
# idea: sort Li, reversed order, iterate through, if
# it's a divisor of K, then return K // Li

segments = sorted(list(map(int, input().strip().split())), reverse=True)
for s in segments:
    if garden_length % s == 0:  # is a divisor
        print(garden_length // s)
        break

# existance guarranteed