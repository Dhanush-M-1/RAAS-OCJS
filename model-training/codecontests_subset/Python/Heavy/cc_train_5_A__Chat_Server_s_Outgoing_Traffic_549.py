from sys import stdin


def ifplus(name, members):

    members.append(name.replace('+', ''))



def ifminus(name, members):

    members.remove(name.replace('-', ''))



def counttraffic(line, members):

    delete = line.find(':')

    line = line[delete + 1::]

    return (len(line) - 1) * len(members)


def getFileData():

    members = []

    traffic = 0
    for line in stdin:

        if line[0] == "+":
            ifplus(line, members)

        elif line[0] == '-':
            ifminus(line, members)

        else:
            traffic += counttraffic(line, members)


    print(traffic)


getFileData()