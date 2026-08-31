#include <bits/stdc++.h>
using namespace std;
bool ara[100001];
int main(int argc, char const *argv[]) {
  int n, m, num, bulb;
  cin >> n >> m;
  while (n--) {
    cin >> num;
    while (num--) {
      cin >> bulb;
      ara[bulb] = true;
    }
  }
  for (int i = 1; i <= m; i++) {
    if (!ara[i]) {
      cout << "NO" << endl;
      return 0;
    }
  }
  cout << "YES" << endl;
  return 0;
}
