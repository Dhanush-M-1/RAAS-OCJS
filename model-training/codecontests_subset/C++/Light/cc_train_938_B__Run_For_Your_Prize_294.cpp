#include <bits/stdc++.h>
using namespace std;
typedef vector<int> vi;
int time_to_pick(int k) { return min(abs(k - 1), abs(1000000 - k)); }
int main() {
  int n;
  cin >> n;
  vi prizes(n);
  int seconds = 0;
  for (int i = 0; i < n; i++) {
    cin >> prizes[i];
    seconds = max(seconds, time_to_pick(prizes[i]));
  }
  cout << seconds << "\n";
  return 0;
}
