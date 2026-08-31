entry = input().split()
objectiveArea = int(entry[1])

# Now we'll get the area that can be watered with each bucket
bucketCapacity = input().split()
for current in range(len(bucketCapacity)):
    bucketCapacity[current] = int(bucketCapacity[current])

# Let's find the biggest bucket that can water the Area exactly
bestBucket = 0

for current in bucketCapacity:
    if objectiveArea/current == objectiveArea//current:
        if current > bestBucket:
            bestBucket = current

# Now that we've found the right bucket, we'll calculate the time it would take
print(objectiveArea//bestBucket)