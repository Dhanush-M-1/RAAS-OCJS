def main():
    bytecount = 0
    participants = []
    try:
        while True:
            line = input()
            
            if line[0] == '+':
                person = line[1:]
                participants.append(person)
            elif line[0] == '-':
                person = line[1:]
                participants.remove(person)
            elif ':' in line:
                person, message = line.split(':')
                bytecount += len(message) * len(participants)
    except EOFError:
        pass

    print(bytecount)

if __name__ == '__main__':
    main()
# 1519772083803
