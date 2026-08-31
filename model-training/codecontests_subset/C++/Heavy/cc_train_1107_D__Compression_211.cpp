#include <bits/stdc++.h>
using namespace std;
long long n, sm[5201][5201];
string s;
int to_digit(char ch) {
  if (isdigit(ch)) {
    return ch - '0';
  }
  return ch - 'A' + 10;
}
vector<long long> get_factor(long long x) {
  vector<long long> ret;
  for (long long i = 1; i * i <= x; i++) {
    if (x % i == 0) {
      ret.push_back(i);
      ret.push_back(x / i);
    }
  }
  return ret;
}
string hex_to_bin(string s) {
  string out;
  for (auto i : s) {
    uint8_t n;
    if (i <= '9' and i >= '0')
      n = i - '0';
    else
      n = 10 + i - 'A';
    for (int8_t j = 3; j >= 0; --j) out.push_back((n & (1 << j)) ? '1' : '0');
  }
  return out;
}
int get_sum(long long x, long long y, long long len) {
  return sm[x][y] - sm[x - len][y] - sm[x][y - len] + sm[x - len][y - len];
}
void solve(long long x) {
  long long cnt = 0;
  for (long long i = x; i <= n; i += x) {
    for (long long j = x; j <= n; j += x) {
      long long sum = get_sum(i, j, x);
      if (sum == 0 || sum == x * x) {
        cnt++;
      }
    }
  }
  if (cnt == (n / x) * (n / x)) {
    cout << x;
    exit(0);
  }
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> s;
    s = hex_to_bin(s);
    long long cnt = 0;
    for (int j = 1; j <= n; j++) {
      cnt += (s[j - 1] == '1');
      sm[i][j] = sm[i - 1][j] + cnt;
    }
  }
  vector<long long> v = get_factor(n);
  sort(v.begin(), v.end(), greater<long long>());
  for (long long x : v) {
    solve(x);
  }
  cout << 1;
  return 0;
}
