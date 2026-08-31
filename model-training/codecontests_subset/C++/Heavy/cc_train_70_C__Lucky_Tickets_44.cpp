#include <bits/stdc++.h>
using namespace std;
template <typename A, typename B>
string to_string(pair<A, B> p);
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p);
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p);
string to_string(const string& s) { return '"' + s + '"'; }
string to_string(const char* s) { return to_string((string)s); }
string to_string(bool b) { return (b ? "true" : "false"); }
string to_string(vector<bool> v) {
  bool first = true;
  string res = "{";
  for (int i = 0; i < static_cast<int>(v.size()); i++) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(v[i]);
  }
  res += "}";
  return res;
}
template <size_t N>
string to_string(bitset<N> v) {
  string res = "";
  for (size_t i = 0; i < N; i++) {
    res += static_cast<char>('0' + v[i]);
  }
  return res;
}
template <typename A>
string to_string(A v) {
  bool first = true;
  string res = "{";
  for (const auto& x : v) {
    if (!first) {
      res += ", ";
    }
    first = false;
    res += to_string(x);
  }
  res += "}";
  return res;
}
template <typename A, typename B>
string to_string(pair<A, B> p) {
  return "(" + to_string(p.first) + ", " + to_string(p.second) + ")";
}
template <typename A, typename B, typename C>
string to_string(tuple<A, B, C> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ")";
}
template <typename A, typename B, typename C, typename D>
string to_string(tuple<A, B, C, D> p) {
  return "(" + to_string(get<0>(p)) + ", " + to_string(get<1>(p)) + ", " +
         to_string(get<2>(p)) + ", " + to_string(get<3>(p)) + ")";
}
void debug_out() { cerr << endl; }
template <typename Head, typename... Tail>
void debug_out(Head H, Tail... T) {
  cerr << " " << to_string(H);
  debug_out(T...);
}
const int N = (int)1e5;
long long md = 998244353;
long long INF = (long long)9e18;
long long val[N], inv[N];
inline long long mul(long long a, long long b) {
  return (long long)((long long)a * b % md);
}
inline int power(long long a, long long b) {
  int res = 1;
  while (b > 0) {
    if (b & 1) {
      res = mul(res, a);
    }
    a = mul(a, a);
    b >>= 1;
  }
  return res;
}
inline int rev(int x) {
  int res = 0;
  while (x) {
    res *= 10;
    res += x % 10;
    x /= 10;
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m, w;
  cin >> n >> m >> w;
  for (int i = 1; i < N; i++) {
    val[i] = (long long)i * power(rev(i), md - 2) % md,
    inv[i] = power(val[i], md - 2);
  }
  map<int, int> cnt[2];
  for (int i = 1; i <= m; i++) {
    cnt[1][val[i]]++;
  }
  int j = m;
  long long sum = 0;
  long long res = INF;
  long long x, y;
  for (int i = 1; i <= n; i++) {
    sum += cnt[1][inv[i]];
    cnt[0][val[i]]++;
    while (j && sum - cnt[0][inv[j]] >= w) {
      cnt[1][val[j]]--;
      sum -= cnt[0][inv[j]];
      j--;
    }
    42;
    if (sum >= w) {
      res = min(res, (long long)i * j);
      if (res == (long long)i * j) {
        x = i;
        y = j;
      }
    }
  }
  if (res == INF) {
    cout << "-1" << '\n';
  } else {
    cout << x << " " << y << '\n';
  }
  return 0;
}
