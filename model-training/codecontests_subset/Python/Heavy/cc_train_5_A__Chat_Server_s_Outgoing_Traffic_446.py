from sys import stdin

lines = stdin.read().splitlines()

Chat_members = []

Bites = 0

Bench = ''

Switch = 0

for line in lines:
    if line[0] == '+':
        for i in range(len(line)):
            if i == (len(line) - 1):
                break
            Bench = Bench + str(line[i + 1])
        Chat_members.append(Bench)
    else:
        if line[0] == '-':
            for i in range(len(line)):
                if i == (len(line) - 1):
                    break
                Bench = Bench + str(line[i + 1])
            Chat_members.remove(Bench)
        else:
            for i in range(len(line)):
                if Switch == 1:
                    Bench = Bench + str(line[i])
                if line[i] == ':':
                    Switch = 1
            Bites = Bites + (len(Chat_members) * len(Bench))

    Bench = ''
    Switch = 0

print(Bites)
