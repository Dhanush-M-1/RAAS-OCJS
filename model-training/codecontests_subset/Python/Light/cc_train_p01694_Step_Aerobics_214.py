DOWN = 0
UP = 1
MOVE_LIST = ["lu","ru","ld","rd"]

def get_input():
    input_data = int(input())
    return input_data

def get_data_list():
    data_list = input().split()
    return data_list


class Manager:
    def __init__(self, move_num, record_list):
        self.move_num = move_num
        self.record_list = record_list
        self.count = 0
        self.right_status = DOWN
        self.left_status = DOWN
        self.kazu_status = DOWN


    def watach_move(self):
        for move in self.record_list:
            if move == "lu":
                self.left_status = UP
            elif move == "ru":
                self.right_status = UP
            elif move == "ld":
                self.left_status = DOWN
            else:
                self.right_status = DOWN
            self.counter()

    def counter(self):
        if self.left_status == self.right_status != self.kazu_status:
            self.kazu_status = self.left_status
            self.count += 1


if __name__ == "__main__":
    while True:
        move_num = get_input()
        if move_num == 0:
            break
        record_list = get_data_list()
        manager = Manager(move_num, record_list)
        manager.watach_move()
        print(manager.count)

