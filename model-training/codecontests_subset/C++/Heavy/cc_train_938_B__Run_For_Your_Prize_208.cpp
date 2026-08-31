#include <bits/stdc++.h>
using namespace std;
vector<int> prizes;
int main() {
  int n;
  cin >> n;
  int prize_idx;
  for (int i = 0; i < n; i++) {
    cin >> prize_idx;
    prizes.push_back(prize_idx);
  }
  int my_loc = 1, friend_loc = 1000000;
  int my_time = 0, friend_time = 0;
  int left_prize = 0, right_prize = n - 1;
  while (right_prize - left_prize > -1) {
    if (my_time + (prizes[left_prize] - my_loc) <
        friend_time + (friend_loc - prizes[right_prize])) {
      my_time += (prizes[left_prize] - my_loc);
      my_loc = prizes[left_prize];
      left_prize++;
    } else {
      friend_time += (friend_loc - prizes[right_prize]);
      friend_loc = prizes[right_prize];
      right_prize--;
    }
  }
  cout << max(my_time, friend_time) << endl;
  return 0;
}
