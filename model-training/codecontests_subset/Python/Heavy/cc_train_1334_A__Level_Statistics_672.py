class Node:
    def __init__(self,value = None,next = None):
        self.value = value
        self.next = next


class LinkedList:
    def __init__(self,head = None):
        self.headNode = head

def check_is_valid_pair(pair):
    if pair[0] < pair[1]:
        return False

    return True

def check_record(n, my_records_list):
    j = 0
    for record_pair in my_records_list:
        if check_is_valid_pair(record_pair) is False:
            print('NO')
            return None
        else:
            if j > 0:
                delta_plays = (my_records_list[j][0] - my_records_list[j-1][0])
                delta_clears = (my_records_list[j][1] - my_records_list[j-1][1])
                if (delta_plays < delta_clears) or delta_clears < 0 or delta_plays < 0:
                    print('NO')
                    return None
        j+=1

    print('YES')
    return None
        
        


if __name__ == "__main__":
    T = int(input())
    my_records_list = []
    for i in range(T):
        n =  int(input())
        my_records_list.clear()
        for j in range(n):
            record_pair = tuple(map(int, input().split()))
            my_records_list.append(record_pair)

        check_record(n, my_records_list)

    

