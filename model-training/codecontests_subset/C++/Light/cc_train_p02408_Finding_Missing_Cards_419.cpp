#include <bits/stdc++.h>
using namespace std;

vector<bool> init() {
  vector<bool> v(14, false);
  return v;
}

int main() {
  int N;
  cin >> N;
  map<char, vector<bool>> Map;
  vector<char> suits = {'S', 'H', 'C', 'D'};
  for (char suit: suits) {
    Map[suit] = init();
  }
  for (int i = 0; i < N; i++) {
    char c; int x;
    cin >> c >> x;
    Map[c][x] = true;
  }
  for (char suit: suits) {
    for (int i = 1; i < 14; i++) {
      if (!Map[suit][i]) cout << suit << ' ' << i << endl;
    }
  }
}
