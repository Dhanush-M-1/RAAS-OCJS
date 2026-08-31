#include <bits/stdc++.h>
using namespace std;
bool way[1000009];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  for (int i = 0; i < 1000009; i++) {
    way[i] = false;
  }
  int n;
  cin >> n;
  int x;
  for (int i = 0; i < n; i++) {
    cin >> x;
    way[x] = true;
  }
  long long int i;
  for (i = 1; i <= 1000000 && n > 0; i++) {
    if (way[i]) {
      n--;
    }
    if (way[1000001 - i]) {
      n--;
    }
  }
  cout << i - 2 << '\n';
  return 0;
}
