#include <bits/stdc++.h>
using namespace std;
int main() {
  std::cin.tie(0);
  std::cin.sync_with_stdio(0);
  int n;
  string victim1, victim2, killed, replacing;
  cin >> victim1 >> victim2;
  cin >> n;
  cout << victim1 << ' ' << victim2 << '\n';
  while (n--) {
    cin >> killed >> replacing;
    if (killed == victim1) {
      victim1 = replacing;
    } else {
      victim2 = replacing;
    }
    cout << victim1 << ' ' << victim2 << '\n';
  }
}
