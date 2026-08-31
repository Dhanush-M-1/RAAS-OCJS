#include <bits/stdc++.h>
using namespace std;
constexpr int MAXN = 5205;
int n, mat[MAXN][MAXN];
std::string s;
inline vector<bool> hx2bin(char c) {
  int val;
  if (c >= 'A')
    val = c - 'A' + 10;
  else
    val = c - '0';
  vector<bool> ret;
  for (int msk = 1 << 3; msk > 0; msk >>= 1) {
    ret.push_back(msk & val);
  }
  return ret;
}
inline void add_to_mat(int i) {
  int j = 1;
  for (char c : s) {
    for (bool bit : hx2bin(c)) {
      mat[i][j] = int(bit) + mat[i][j - 1] + mat[i - 1][j] - mat[i - 1][j - 1];
      ++j;
    }
  }
}
inline bool is_okay(int x) {
  for (int i = x; i <= n; i += x) {
    for (int j = x; j <= n; j += x) {
      int ss = mat[i][j] - mat[i - x][j] - mat[i][j - x] + mat[i - x][j - x];
      if (ss == 0 || ss == x * x)
        continue;
      else
        return false;
    }
  }
  return true;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin >> n;
  for (int i = 1; i <= n; ++i) {
    cin >> s;
    add_to_mat(i);
  }
  int best_x = 1;
  for (int x = 1; x * x <= n; ++x) {
    if (n % x) continue;
    if (is_okay(n / x)) {
      best_x = n / x;
      break;
    } else if (is_okay(x)) {
      best_x = x;
    }
  }
  cout << best_x << '\n';
}
