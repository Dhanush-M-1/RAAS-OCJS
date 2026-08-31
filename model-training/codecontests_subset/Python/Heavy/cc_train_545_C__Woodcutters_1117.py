from collections import deque
import sys

class Tree:
    def __init__(self, pos, height):
        self.pos = pos;
        self.height = height;

line = input().split(" ");
test_cases = int(line[0]);

trees_lr = deque([]);

for tc in range(test_cases):
    line = input().split(" ");
    trees_lr.append(Tree(int(line[0]), int(line[1])));

if(len(trees_lr) == 1):
    sys.stdout.write(str(1));
else:
    lb = trees_lr.popleft().pos;
    ub = trees_lr.pop().pos;
    #print("lb: " + str(lb) + " ub: " + str(ub));
    count = 2;
    is_left = True;
    while(trees_lr):
        #print(len(trees_lr));
        #print(is_left);
        if(is_left):
            cur_tree = trees_lr.popleft();
            if(cur_tree.pos - cur_tree.height > lb):
                count += 1;
                #print("New count: " + str(count));
                lb = cur_tree.pos;
            else:
                if(trees_lr):
                    next_tree = trees_lr.popleft();
                    next_pos = next_tree.pos;
                    trees_lr.appendleft(next_tree);
                else:
                    next_pos = ub;
                if(cur_tree.pos + cur_tree.height < next_pos):
                    count += 1;
                    lb = cur_tree.pos + cur_tree.height;
                    #print("New count: " + str(count));
                else:
                    lb = cur_tree.pos;
            is_left = False;
        else:
            cur_tree =  trees_lr.pop();
            if(cur_tree.pos + cur_tree.height < ub):
                count += 1;
                #print("New count: " + str(count));
                ub = cur_tree.pos;
            else:
                if(trees_lr):
                    next_tree = trees_lr.pop();
                    next_pos = next_tree.pos;
                    trees_lr.append(next_tree);
                else:
                    next_pos = lb;
                if(cur_tree.pos - cur_tree.height > next_pos):
                    count += 1;
                    ub = cur_tree.pos - cur_tree.height;
                    #print("New count: " + str(count));
                else:
                    ub = cur_tree.pos;
            is_left = True;
        #print("lb: " + str(lb) + " ub: " + str(ub));
    #print()
    sys.stdout.write(str(count));