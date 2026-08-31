#include <bits/stdc++.h>
using namespace std;
void yala_bena() {
  cin.tie(0);
  std::ios::sync_with_stdio(0);
}
const int m_r = 999999;
int main() {
  yala_bena();
  int n, a, h1 = 0, h2 = 0;
  long long sum = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a;
    if (a == 100)
      h1++;
    else
      h2++;
    sum += a;
  }
  if (h1 == 0 && h2) {
    if (h2 % 2) {
      cout << "NO" << endl;
      return 0;
    } else {
      cout << "YES" << endl;
      return 0;
    }
  } else if (h2 == 0 && h1) {
    if (h1 % 2) {
      cout << "NO" << endl;
      return 0;
    } else {
      cout << "YES" << endl;
      return 0;
    }
  } else if (h1 == h2) {
    if (h1 % 2 == 0 && h2 % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    } else {
      cout << "NO" << endl;
      return 0;
    }
  } else if (h1 < h2) {
    if (h1 % 2 == 0 && h2 % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    } else if (h2 & 2 == 0 && h1 % 2 == 1) {
      cout << "NO" << endl;
      return 0;
    } else if (h2 % 2 == 1 && h1 % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    }
  } else if (h2 < h1) {
    if (h1 % 2 == 0 && h2 % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    } else if (h2 & 2 == 0 && h1 % 2 == 1) {
      cout << "NO" << endl;
      return 0;
    } else if (h2 % 2 == 1 && h1 % 2 == 0) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
}
