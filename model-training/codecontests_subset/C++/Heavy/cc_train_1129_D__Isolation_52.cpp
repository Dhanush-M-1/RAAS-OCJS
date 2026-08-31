#include <bits/stdc++.h>
using namespace std;
template <typename T>
istream& operator>>(istream& is, vector<T>& v) {
  for (auto& i : v) is >> i;
  return is;
}
template <typename T>
ostream& operator<<(ostream& os, vector<T>& v) {
  for (auto& i : v) os << i << ' ';
  return os;
}
template <typename T, typename U>
istream& operator>>(istream& is, pair<T, U>& p) {
  is >> p.first >> p.second;
  return is;
}
template <typename T, typename U>
ostream& operator<<(ostream& os, pair<T, U>& p) {
  os << p.first << ' ' << p.second;
  return os;
}
template <typename T, typename U>
pair<T, U> operator-(pair<T, U> a, pair<T, U> b) {
  return make_pair(a.first - b.first, a.second - b.second);
}
template <typename T, typename U>
pair<T, U> operator+(pair<T, U> a, pair<T, U> b) {
  return make_pair(a.first + b.first, a.second + b.second);
}
const int K = 330;
const long long mod = 998244353;
array<long long, K * K> dp;
struct Block {
  int ind;
  array<int, K> b;
  array<long long, 2 * K + 1> sms;
  int sm = 0;
  Block(int i = -1) : ind(i) {
    b.fill(0);
    sms.fill(0);
  }
  void reset() {
    sms.fill(0);
    sm = 0;
    for (int i = K - 1; i >= 0; --i) {
      sm += b[i];
      if (ind == 0 && i == 0)
        sms[K + sm]++;
      else
        sms[K + sm] += dp[ind * K + i - 1];
    }
    for (int i = 1; i < sms.size(); ++i) sms[i] = (sms[i] + sms[i - 1]) % mod;
    sms[0] %= mod;
  }
  long long ask(int u) {
    if (u + K < 0)
      return 0;
    else if (u + K >= sms.size())
      return sms.back();
    else
      return sms[u + K];
  }
  void change(int ind, int k) {
    b[ind] = k;
    reset();
  }
};
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  vector<Block> blocks(K);
  for (int i = 0; i < K; ++i) {
    blocks[i].ind = i;
  }
  int n, k;
  cin >> n >> k;
  vector<int> vv(n);
  cin >> vv;
  vector<int> lst(n + 1, -1);
  vector<int> prev(n);
  for (int i = 0; i < n; ++i) {
    prev[i] = lst[vv[i]];
    lst[vv[i]] = i;
  }
  for (int i = 0; i < n; ++i) {
    blocks[i / K].change(i % K, 1);
    if (prev[i] != -1) {
      if (prev[prev[i]] != -1) {
        blocks[prev[prev[i]] / K].change(prev[prev[i]] % K, 0);
      }
      blocks[prev[i] / K].change(prev[i] % K, -1);
    }
    42;
    ;
    int s = 0;
    for (int j = i; j >= i / K * K; --j) {
      s += blocks[i / K].b[j % K];
      if (s <= k) dp[i] += (j == 0 ? 1 : dp[j - 1]);
    }
    for (int j = i / K - 1; j >= 0; --j) {
      dp[i] += blocks[j].ask(k - s);
      s += blocks[j].sm;
    }
    dp[i] %= mod;
    if (i % K == 0) blocks[i / K].reset();
  }
  42;
  ;
  42;
  ;
  cout << dp[n - 1] << '\n';
  return 0;
}
