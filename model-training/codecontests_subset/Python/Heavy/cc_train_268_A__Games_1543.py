# Holds the number of teams there will be
teams = int(input())
# Creates the dictionary of the team's uniform's colors
colors = dict()
count = 0

# Stores the information inside the dictionary
for i in range(teams):
    colors[i] = [int(s) for s in input().split()]

# Creates a loop that will run "teams" amount of times
for i in range(teams):
    # Creates another identical loop
    for j in range(teams):
        # Skips a turn in the loop if the outer loop equals the inner.
        if i == j:
            continue
        # Checks of the host's home color is equal to the visitor's away color.
        if colors[i][0] == colors[j][1]:
            count += 1

# Prints the count of instances
print(count)