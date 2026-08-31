#include <iostream>
#include <set>
using namespace std;

int main() {
  int n;
  cin >> n;
  set<pair<char, int>> s;
  for (int i = 0; i < n; i++) {
    char c;
    int x;
    cin >> c >> x;
    s.insert(make_pair(c, x));
  }
  string cards = "SHCD";
  for (int i = 0; i < 4; i++) {
    for (int j = 1; j <= 13; j++) {
      if (!s.count(make_pair(cards[i], j))) cout << cards[i] << ' ' << j << endl;
    }
  }
}

