intro = input()
variables = [int(x) for x in intro.split(" ")]
buttons = variables[0]
bulbs = variables[1]

onBulbs = set()
for button in range(buttons):
    connections = input().split(" ")
    for connection in connections[1::]:
        onBulbs.add(int(connection))
    
if onBulbs == set(range(1,bulbs + 1)):
    print("YES")
else:
    print("NO")