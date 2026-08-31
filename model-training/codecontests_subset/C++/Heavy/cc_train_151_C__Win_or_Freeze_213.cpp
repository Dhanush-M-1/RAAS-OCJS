#include <bits/stdc++.h>
using namespace std;
int arr[300] = {0};
struct player {
  int index;
  int skill;
};
bool compare(player a, player b) { return a.skill < b.skill; }
int main() {
  vector<long long int> rs;
  long long int q;
  cin >> q;
  if (q == 1) {
    cout << 1 << endl;
    cout << 0 << endl;
  } else {
    for (long long int i = 2; i * i <= q; ++i) {
      while (q % i == 0) {
        rs.push_back(i);
        q /= i;
      }
    }
    if (q > 1) rs.push_back(q);
    if (rs.size() == 1) {
      cout << 1 << endl;
      cout << 0 << endl;
    } else if (rs.size() == 2) {
      cout << 2 << endl;
    } else {
      cout << 1 << endl;
      cout << rs[0] * rs[1] << endl;
    }
  }
  return 0;
}
