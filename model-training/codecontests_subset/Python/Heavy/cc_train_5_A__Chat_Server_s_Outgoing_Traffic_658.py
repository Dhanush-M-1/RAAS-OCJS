################################################################################
class ChatServer:
    # Class method to parse a given command from stdin.
    @classmethod
    def parseCommand(cls,commandString):
        if commandString[0] == '+':
            return {'A':'Add','U':commandString.split('+')[1].split('\n')[0]}
        elif commandString[0] == '-':
            return {'A':'Remove','U':commandString.split('-')[1].split('\n')[0]}
        else:
            content = commandString.split(':')
            return {'A':'Send','S':content[0],'M':content[1].split('\n')[0]}
    # Class method to compute traffic post parsing command.
    @classmethod
    def updateChatServerWith(cls,commandPacket):
        if commandPacket['A'] == 'Add':
            ChatServer.persons.add(commandPacket['U'])
        elif commandPacket['A'] == 'Remove':
            ChatServer.persons.remove(commandPacket['U'])
        else:
            userCount = len(ChatServer.persons)
            ChatServer.traffic+=userCount*len(commandPacket['M'])
    # For storing persons and keeping traffic count.
    persons,traffic = set(),0
################################################################################
import sys
for command in sys.stdin:
    ChatServer.updateChatServerWith(ChatServer.parseCommand(command))
print(ChatServer.traffic)
################################################################################
