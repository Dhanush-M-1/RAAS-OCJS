#!/bin/python3

# n trees located along the road
# coordinates of tree i is x[i]
# height of tree i is h[i]
# you can fell a tree left or right
# it will then occupy either x[i] - h[i] to x[i] or x[i] to x[i] + h[i]
# an uncut tree occupies x[i]
# what are the maximum trees?

# BRUTEFORCE:

LEFT = 1
RIGHT = 2

# get input data
n = int(input())
trees = []
for i in range(n):
    a = input().split(" ")
    trees.append([int(a[0]), int(a[1]), None])

count = 0
for i in range(len(trees)):
    if i == 0:
        count += 1
        trees[i][2] = LEFT
        continue

    if i == len(trees) - 1:
        count += 1
        trees[i][2] = RIGHT
        continue

    pr = trees[i - 1]
    ne = trees[i + 1]

    dl = trees[i][0] - trees[i][1]
    dr = trees[i][0] + trees[i][1]

    # check if we can fall left

    if pr[2] == LEFT or pr[2] == None:
        if (dl > pr[0]):
            trees[i][2] = LEFT
            count += 1
            continue
    else:
        if (dl > (pr[0] + pr[1])):
            trees[i][2] = LEFT
            count += 1
            continue

    # check if we can fall right

    if ne[2] == RIGHT or ne[2] == None:
        if (dr < ne[0]):
            trees[i][2] = RIGHT
            count += 1
            continue

print(count)
    



